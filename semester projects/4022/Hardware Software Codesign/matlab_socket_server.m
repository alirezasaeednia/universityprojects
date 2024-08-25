srv = tcpip('0.0.0.0', 30000, 'NetworkRole', 'server');

set(srv, 'InputBufferSize', 1024);

disp('Server is ready to accept connections...');

data_i = [];
data_j = [];

while true
    if strcmp(srv.Status, 'closed')
        try
            fopen(srv);
            disp('Client connected.');
        catch ME
            disp('Failed to open connection:');
            disp(ME.identifier);
            disp(ME.message);
            pause(1); 
            continue;
        end
    end
    
    try
        if srv.BytesAvailable > 0
            received_data = fscanf(srv, '%c', srv.BytesAvailable);
            if isempty(received_data)
                continue; 
            end
            
            disp(['Received data: ', received_data]);

            if contains(received_data, "data_i:")
                data_i_str = extractBetween(received_data, "data_i:", "\n");
                data_i_vals = sscanf(data_i_str{1}, '%d');
                if ~isempty(data_i_vals)
                    data_i = data_i_vals';
                end
            end
            
            if contains(received_data, "data_j:")
                data_j_str = extractBetween(received_data, "data_j:", "\n");
                data_j_vals = sscanf(data_j_str{1}, '%d');
                if ~isempty(data_j_vals)
                    data_j = data_j_vals';
                end
            end

            if ~isempty(data_i) && ~isempty(data_j)
                updated_data_i = modify_data(data_i, data_j);

                fprintf(srv, 'updated_data_i:');
                fprintf(srv, ' %d', updated_data_i);
                fprintf(srv, '\n');

                data_i = [];
                data_j = [];
            end
        end
    catch ME
        if strcmp(srv.Status, 'open')
            fclose(srv);
        end
        pause(1);
    end
    pause(0.1); 
end

if strcmp(srv.Status, 'open')
    fclose(srv);
end
delete(srv);
clear srv;

function updated_data_i = modify_data(data_i, data_j)
    dist = compute_distance(data_i, data_j);
    beta = exp(-10 * dist * dist);
    alpha = 0.5;
    for k = 1:length(data_i)
        rand_term = alpha * (rand - 0.5);
        data_i(k) = data_i(k) + beta * (data_j(k) - data_i(k)) + rand_term;
        data_i(k) = data_i(k) > 0.5; 
    end
    updated_data_i = data_i;
end

function dist = compute_distance(data_i, data_j)
    dist = sqrt(sum((data_i - data_j).^2));
end