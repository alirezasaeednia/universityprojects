#include <systemc.h>
#include <vector>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <climits>
#include <sstream> 

#define POP_SIZE 20
#define MAX_GEN 100
#define NUM_ITEMS 10

std::string int_to_str(int num) {
    std::stringstream ss;
    ss << num;
    return ss.str();
}

SC_MODULE(Firefly) {
    sc_in<bool> clk;
    sc_out<int> best_solution[NUM_ITEMS];
    sc_out<int> best_value;
    sc_out<int> total_weight;

    SC_CTOR(Firefly) {
        SC_THREAD(run);
        sensitive << clk.pos();
        srand(time(0));
    }

    int population[POP_SIZE][NUM_ITEMS];
    int item_values[NUM_ITEMS] = {6, 5, 8, 9, 6, 7, 3, 6, 8, 5}; 
    int item_weights[NUM_ITEMS] = {2, 3, 6, 7, 5, 9, 3, 4, 5, 6};
    int best_solution_array[NUM_ITEMS];
    int best_value_int;
    int total_weight_int;

    void run();
    void init_population();
    void evaluate_population(int &best_value, int &total_weight, int best_solution[NUM_ITEMS]);
    void update_position(int sol_i[NUM_ITEMS], int sol_j[NUM_ITEMS]);
    double calc_distance(int sol_i[NUM_ITEMS], int sol_j[NUM_ITEMS]);
    int calc_fitness(int solution[NUM_ITEMS], int &value, int &weight); 
};

void Firefly::run() {
    init_population();
    best_value_int = 0;
    total_weight_int = INT_MAX;

    for (int iter = 0; iter < MAX_GEN; iter++) {
        for (int i = 0; i < POP_SIZE; i++) {
            for (int j = 0; j < POP_SIZE; j++) {
                if (i != j) {
                    int value_i, weight_i, value_j, weight_j;
                    calc_fitness(population[i], value_i, weight_i);
                    calc_fitness(population[j], value_j, weight_j);

                    if (value_j > value_i && weight_j < weight_i) {
                        update_position(population[i], population[j]);
                    }
                }
            }
        }

        evaluate_population(best_value_int, total_weight_int, best_solution_array);

        for (int i = 0; i < NUM_ITEMS; i++) {
            best_solution[i].write(best_solution_array[i]);
        }
        best_value.write(best_value_int);
        total_weight.write(total_weight_int);
        wait();
    }
}

void Firefly::init_population() { 
    for (int i = 0; i < POP_SIZE; i++) {
        for (int j = 0; j < NUM_ITEMS; j++) {
            population[i][j] = rand() % 2;
        }
    }
}

void Firefly::evaluate_population(int &best_value, int &total_weight, int best_solution[NUM_ITEMS]) {
    for (int i = 0; i < POP_SIZE; i++) {
        int value, weight;
        calc_fitness(population[i], value, weight);
        if (value > best_value && weight < total_weight) {
            best_value = value;
            total_weight = weight;
            for (int j = 0; j < NUM_ITEMS; j++) {
                best_solution[j] = population[i][j];
            }
        }
    }
}

int Firefly::calc_fitness(int solution[NUM_ITEMS], int &value, int &weight) {
    value = 0;
    weight = 0;
    for (int i = 0; i < NUM_ITEMS; i++) {
        value += solution[i] * item_values[i];
        weight += solution[i] * item_weights[i];
    }
    return value;
}

void Firefly::update_position(int sol_i[NUM_ITEMS], int sol_j[NUM_ITEMS]) {
    double r_ij = calc_distance(sol_i, sol_j);
    double beta = exp(-10 * r_ij * r_ij);
    double alpha = 0.5;
    for (int i = 0; i < NUM_ITEMS; i++) {
        double random_term = alpha * ((rand() / (double)RAND_MAX) - 0.5);
        sol_i[i] = sol_i[i] + beta * (sol_j[i] - sol_i[i]) + random_term;
        sol_i[i] = sol_i[i] > 0.5 ? 1 : 0; 
    }
}

double Firefly::calc_distance(int sol_i[NUM_ITEMS], int sol_j[NUM_ITEMS]) {
    double distance = 0.0;
    for (int i = 0; i < NUM_ITEMS; i++) {
        distance += (sol_i[i] - sol_j[i]) * (sol_i[i] - sol_j[i]);
    }
    return sqrt(distance);
}

SC_MODULE(SystemTop) {
    sc_clock clk;
    sc_signal<int> best_solution[NUM_ITEMS];
    sc_signal<int> best_value;
    sc_signal<int> total_weight;

    Firefly firefly;

    SC_CTOR
    R(SystemTop) : clk("clk", 10, SC_NS), firefly("firefly") {
        firefly.clk(clk);
        for (int i = 0; i < NUM_ITEMS; i++) {
            firefly.best_solution[i](best_solution[i]);
        }
        firefly.best_value(best_value);
        firefly.total_weight(total_weight);

        SC_THREAD(monitor);
        sensitive << best_value << total_weight;
    }

    void monitor() {
        while (true) {
            wait();
            std::cout << "At time " << sc_time_stamp() << ":\n";
            std::cout << "Best Value: " << best_value.read() << "\n";
            std::cout << "Total Weight: " << total_weight.read() << "\n";
            std::cout << "Best Solution: ";
            for (int i = 0; i < NUM_ITEMS; i++) {
                std::cout << best_solution[i].read() << " ";
            }
            std::cout << "\n";
        }
    }
};

int sc_main(int argc, char* argv[]) {
    SystemTop top("top");
    sc_trace_file *wf = sc_create_vcd_trace_file("firefly_trace");

    sc_trace(wf, top.best_value, "Best_Value");
    sc_trace(wf, top.total_weight, "Total_Weight");
    for (int i = 0; i < NUM_ITEMS; i++) {
        std::string name = "Best_Solution_" + int_to_str(i+1);
        sc_trace(wf, top.best_solution[i], name.c_str());
    }

    sc_start(1000, SC_NS);
    sc_close_vcd_trace_file(wf);
    return 0;
}
