// $ANTLR 3.5.1 C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g 2023-07-02 18:18:59

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class sParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASSIGN", "BCLOSE", "BOPEN", 
		"B_AND", "B_OR", "CASE", "CCLOSE", "CHAR", "COMMENT", "COPEN", "DIVIDE", 
		"DO", "ELIF", "ELSE", "EQ", "ESC_SEQ", "EXPONENT", "FLOAT", "FOR", "FUNCTION", 
		"GEQ", "GT", "HEX_DIGIT", "ID", "IF", "INT", "LCLOSE", "LEQ", "LOPEN", 
		"LT", "MULTIPLY", "NEQ", "OCTAL_ESC", "OR", "PLUS", "POWER", "REM", "RETURN", 
		"SEMI", "SLL", "SRL", "STRING", "SUB", "SWITCH", "T_CHAR", "T_FLOAT", 
		"T_INT", "T_STRING", "UNICODE_ESC", "WHILE", "WS", "XOR", "','"
	};
	public static final int EOF=-1;
	public static final int T__57=57;
	public static final int AND=4;
	public static final int ASSIGN=5;
	public static final int BCLOSE=6;
	public static final int BOPEN=7;
	public static final int B_AND=8;
	public static final int B_OR=9;
	public static final int CASE=10;
	public static final int CCLOSE=11;
	public static final int CHAR=12;
	public static final int COMMENT=13;
	public static final int COPEN=14;
	public static final int DIVIDE=15;
	public static final int DO=16;
	public static final int ELIF=17;
	public static final int ELSE=18;
	public static final int EQ=19;
	public static final int ESC_SEQ=20;
	public static final int EXPONENT=21;
	public static final int FLOAT=22;
	public static final int FOR=23;
	public static final int FUNCTION=24;
	public static final int GEQ=25;
	public static final int GT=26;
	public static final int HEX_DIGIT=27;
	public static final int ID=28;
	public static final int IF=29;
	public static final int INT=30;
	public static final int LCLOSE=31;
	public static final int LEQ=32;
	public static final int LOPEN=33;
	public static final int LT=34;
	public static final int MULTIPLY=35;
	public static final int NEQ=36;
	public static final int OCTAL_ESC=37;
	public static final int OR=38;
	public static final int PLUS=39;
	public static final int POWER=40;
	public static final int REM=41;
	public static final int RETURN=42;
	public static final int SEMI=43;
	public static final int SLL=44;
	public static final int SRL=45;
	public static final int STRING=46;
	public static final int SUB=47;
	public static final int SWITCH=48;
	public static final int T_CHAR=49;
	public static final int T_FLOAT=50;
	public static final int T_INT=51;
	public static final int T_STRING=52;
	public static final int UNICODE_ESC=53;
	public static final int WHILE=54;
	public static final int WS=55;
	public static final int XOR=56;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "op", "case_st", "synpred62_s", "synpred1_s", "synpred93_s", 
		"init", "else_st", "synpred11_s", "synpred90_s", "else_if_st", "synpred40_s", 
		"synpred77_s", "b_op", "synpred41_s", "synpred5_s", "synpred87_s", "synpred9_s", 
		"synpred79_s", "synpred108_s", "synpred76_s", "synpred56_s", "switch_st", 
		"type1", "condition", "synpred42_s", "m", "synpred15_s", "synpred23_s", 
		"synpred85_s", "synpred110_s", "synpred50_s", "synpred69_s", "params", 
		"synpred99_s", "c", "synpred46_s", "synpred98_s", "n", "synpred103_s", 
		"synpred16_s", "statements", "synpred63_s", "synpred6_s", "no", "synpred105_s", 
		"synpred65_s", "e", "synpred35_s", "w", "synpred64_s", "synpred112_s", 
		"synpred20_s", "synpred80_s", "synpred13_s", "synpred49_s", "synpred94_s", 
		"synpred30_s", "synpred8_s", "def_params", "synpred19_s", "synpred18_s", 
		"function_st", "conOp", "synpred32_s", "synpred7_s", "synpred26_s", "function_def", 
		"r", "synpred52_s", "start", "synpred2_s", "synpred88_s", "synpred96_s", 
		"synpred27_s", "synpred92_s", "synpred4_s", "synpred67_s", "synpred82_s", 
		"synpred102_s", "synpred34_s", "synpred104_s", "synpred109_s", "synpred31_s", 
		"synpred101_s", "synpred58_s", "condition2", "synpred3_s", "v", "synpred28_s", 
		"synpred14_s", "synpred43_s", "synpred100_s", "synpred107_s", "type", 
		"synpred17_s", "synpred45_s", "synpred29_s", "synpred84_s", "for_st", 
		"block", "do_st", "f", "synpred95_s", "synpred78_s", "synpred66_s", "synpred48_s", 
		"synpred33_s", "while_st", "synpred47_s", "synpred53_s", "synpred61_s", 
		"synpred12_s", "synpred24_s", "g", "s", "synpred86_s", "synpred111_s", 
		"synpred51_s", "statement", "assign_st", "synpred54_s", "synpred97_s", 
		"synpred22_s", "synpred72_s", "synpred55_s", "synpred60_s", "synpred70_s", 
		"if_st", "synpred36_s", "synpred38_s", "synpred68_s", "synpred57_s", "blocks", 
		"synpred25_s", "synpred74_s", "synpred89_s", "synpred83_s", "synpred44_s", 
		"synpred59_s", "synpred21_s", "synpred37_s", "synpred39_s", "synpred73_s", 
		"synpred106_s", "synpred75_s", "synpred71_s", "synpred91_s", "synpred81_s", 
		"synpred10_s"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, true, false, false, false, false, false, false, false, false, 
		    false, false, true, false, false, false, false, false, false, false, 
		    true, false, false, true, false, false, false, false, false, false, 
		    false, false, false, false, true, false, false, false, false, false, 
		    false, false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public sParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public sParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this, port, null);

		setDebugListener(proxy);
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
	}

	public sParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return sParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g"; }



	// $ANTLR start "start"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:11:1: start : ( blocks )* EOF ;
	public final void start() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "start");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(11, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:11:7: ( ( blocks )* EOF )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:11:9: ( blocks )* EOF
			{
			dbg.location(11,9);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:11:9: ( blocks )*
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==BOPEN||LA1_0==DO||(LA1_0 >= FOR && LA1_0 <= FUNCTION)||(LA1_0 >= ID && LA1_0 <= IF)||(LA1_0 >= SWITCH && LA1_0 <= T_STRING)||LA1_0==WHILE) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:11:9: blocks
					{
					dbg.location(11,9);
					pushFollow(FOLLOW_blocks_in_start37);
					blocks();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop1;
				}
			}
			} finally {dbg.exitSubRule(1);}
			dbg.location(11,17);
			match(input,EOF,FOLLOW_EOF_in_start40); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(12, 0);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "start");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "start"



	// $ANTLR start "blocks"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:14:1: blocks : ( function_def | BOPEN block BCLOSE | block );
	public final void blocks() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "blocks");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(14, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:14:8: ( function_def | BOPEN block BCLOSE | block )
			int alt2=3;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			switch ( input.LA(1) ) {
			case FUNCTION:
				{
				alt2=1;
				}
				break;
			case BOPEN:
				{
				alt2=2;
				}
				break;
			case DO:
			case FOR:
			case ID:
			case IF:
			case SWITCH:
			case T_CHAR:
			case T_FLOAT:
			case T_INT:
			case T_STRING:
			case WHILE:
				{
				alt2=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:14:11: function_def
					{
					dbg.location(14,11);
					pushFollow(FOLLOW_function_def_in_blocks50);
					function_def();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:14:25: BOPEN block BCLOSE
					{
					dbg.location(14,25);
					match(input,BOPEN,FOLLOW_BOPEN_in_blocks53); if (state.failed) return;dbg.location(14,31);
					pushFollow(FOLLOW_block_in_blocks55);
					block();
					state._fsp--;
					if (state.failed) return;dbg.location(14,37);
					match(input,BCLOSE,FOLLOW_BCLOSE_in_blocks57); if (state.failed) return;
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:14:46: block
					{
					dbg.location(14,46);
					pushFollow(FOLLOW_block_in_blocks61);
					block();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(15, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "blocks");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "blocks"



	// $ANTLR start "block"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:17:1: block : statements ;
	public final void block() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(17, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:17:7: ( statements )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:17:9: statements
			{
			dbg.location(17,9);
			pushFollow(FOLLOW_statements_in_block72);
			statements();
			state._fsp--;
			if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(18, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block"



	// $ANTLR start "statements"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:20:1: statements : statement ( statement )* ;
	public final void statements() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "statements");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(20, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:21:2: ( statement ( statement )* )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:21:4: statement ( statement )*
			{
			dbg.location(21,4);
			pushFollow(FOLLOW_statement_in_statements85);
			statement();
			state._fsp--;
			if (state.failed) return;dbg.location(21,14);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:21:14: ( statement )*
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=2;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				switch ( input.LA(1) ) {
				case T_CHAR:
				case T_FLOAT:
				case T_INT:
				case T_STRING:
					{
					int LA3_5 = input.LA(2);
					if ( (synpred4_s()) ) {
						alt3=1;
					}

					}
					break;
				case ID:
					{
					int LA3_6 = input.LA(2);
					if ( (synpred4_s()) ) {
						alt3=1;
					}

					}
					break;
				case IF:
					{
					int LA3_7 = input.LA(2);
					if ( (synpred4_s()) ) {
						alt3=1;
					}

					}
					break;
				case WHILE:
					{
					int LA3_8 = input.LA(2);
					if ( (synpred4_s()) ) {
						alt3=1;
					}

					}
					break;
				case DO:
					{
					int LA3_9 = input.LA(2);
					if ( (synpred4_s()) ) {
						alt3=1;
					}

					}
					break;
				case FOR:
					{
					int LA3_10 = input.LA(2);
					if ( (synpred4_s()) ) {
						alt3=1;
					}

					}
					break;
				case SWITCH:
					{
					int LA3_11 = input.LA(2);
					if ( (synpred4_s()) ) {
						alt3=1;
					}

					}
					break;
				}
				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:21:14: statement
					{
					dbg.location(21,14);
					pushFollow(FOLLOW_statement_in_statements87);
					statement();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop3;
				}
			}
			} finally {dbg.exitSubRule(3);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(22, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "statements");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "statements"



	// $ANTLR start "statement"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:24:1: statement : ( assign_st SEMI | if_st | function_st | while_st | do_st | for_st | switch_st );
	public final void statement() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(24, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:25:2: ( assign_st SEMI | if_st | function_st | while_st | do_st | for_st | switch_st )
			int alt4=7;
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			switch ( input.LA(1) ) {
			case T_CHAR:
			case T_FLOAT:
			case T_INT:
			case T_STRING:
				{
				alt4=1;
				}
				break;
			case ID:
				{
				int LA4_2 = input.LA(2);
				if ( (LA4_2==LOPEN) ) {
					alt4=3;
				}
				else if ( (LA4_2==ASSIGN||LA4_2==COPEN||LA4_2==SEMI) ) {
					alt4=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 2, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IF:
				{
				alt4=2;
				}
				break;
			case WHILE:
				{
				alt4=4;
				}
				break;
			case DO:
				{
				alt4=5;
				}
				break;
			case FOR:
				{
				alt4=6;
				}
				break;
			case SWITCH:
				{
				alt4=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:25:4: assign_st SEMI
					{
					dbg.location(25,4);
					pushFollow(FOLLOW_assign_st_in_statement100);
					assign_st();
					state._fsp--;
					if (state.failed) return;dbg.location(25,14);
					match(input,SEMI,FOLLOW_SEMI_in_statement102); if (state.failed) return;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:25:21: if_st
					{
					dbg.location(25,21);
					pushFollow(FOLLOW_if_st_in_statement106);
					if_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:25:29: function_st
					{
					dbg.location(25,29);
					pushFollow(FOLLOW_function_st_in_statement110);
					function_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:25:43: while_st
					{
					dbg.location(25,43);
					pushFollow(FOLLOW_while_st_in_statement114);
					while_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:25:53: do_st
					{
					dbg.location(25,53);
					pushFollow(FOLLOW_do_st_in_statement117);
					do_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:25:60: for_st
					{
					dbg.location(25,60);
					pushFollow(FOLLOW_for_st_in_statement120);
					for_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:25:68: switch_st
					{
					dbg.location(25,68);
					pushFollow(FOLLOW_switch_st_in_statement123);
					switch_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(26, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "statement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "statement"



	// $ANTLR start "switch_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:28:1: switch_st : SWITCH LOPEN ID LCLOSE BOPEN ( case_st )* BCLOSE ;
	public final void switch_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "switch_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(28, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:29:2: ( SWITCH LOPEN ID LCLOSE BOPEN ( case_st )* BCLOSE )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:29:4: SWITCH LOPEN ID LCLOSE BOPEN ( case_st )* BCLOSE
			{
			dbg.location(29,4);
			match(input,SWITCH,FOLLOW_SWITCH_in_switch_st135); if (state.failed) return;dbg.location(29,11);
			match(input,LOPEN,FOLLOW_LOPEN_in_switch_st137); if (state.failed) return;dbg.location(29,17);
			match(input,ID,FOLLOW_ID_in_switch_st139); if (state.failed) return;dbg.location(29,20);
			match(input,LCLOSE,FOLLOW_LCLOSE_in_switch_st141); if (state.failed) return;dbg.location(29,27);
			match(input,BOPEN,FOLLOW_BOPEN_in_switch_st143); if (state.failed) return;dbg.location(29,33);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:29:33: ( case_st )*
			try { dbg.enterSubRule(5);

			loop5:
			while (true) {
				int alt5=2;
				try { dbg.enterDecision(5, decisionCanBacktrack[5]);

				int LA5_0 = input.LA(1);
				if ( (LA5_0==CASE) ) {
					alt5=1;
				}

				} finally {dbg.exitDecision(5);}

				switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:29:33: case_st
					{
					dbg.location(29,33);
					pushFollow(FOLLOW_case_st_in_switch_st145);
					case_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop5;
				}
			}
			} finally {dbg.exitSubRule(5);}
			dbg.location(29,42);
			match(input,BCLOSE,FOLLOW_BCLOSE_in_switch_st148); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(30, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "switch_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "switch_st"



	// $ANTLR start "case_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:31:1: case_st : CASE LOPEN no LCLOSE BOPEN statements BCLOSE ;
	public final void case_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "case_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(31, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:31:9: ( CASE LOPEN no LCLOSE BOPEN statements BCLOSE )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:31:11: CASE LOPEN no LCLOSE BOPEN statements BCLOSE
			{
			dbg.location(31,11);
			match(input,CASE,FOLLOW_CASE_in_case_st158); if (state.failed) return;dbg.location(31,16);
			match(input,LOPEN,FOLLOW_LOPEN_in_case_st160); if (state.failed) return;dbg.location(31,22);
			pushFollow(FOLLOW_no_in_case_st162);
			no();
			state._fsp--;
			if (state.failed) return;dbg.location(31,25);
			match(input,LCLOSE,FOLLOW_LCLOSE_in_case_st164); if (state.failed) return;dbg.location(31,32);
			match(input,BOPEN,FOLLOW_BOPEN_in_case_st166); if (state.failed) return;dbg.location(31,38);
			pushFollow(FOLLOW_statements_in_case_st168);
			statements();
			state._fsp--;
			if (state.failed) return;dbg.location(31,49);
			match(input,BCLOSE,FOLLOW_BCLOSE_in_case_st170); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(32, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "case_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "case_st"



	// $ANTLR start "for_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:1: for_st : FOR LOPEN ( ( init )? SEMI ( condition )? SEMI ( assign_st )? ) LCLOSE BOPEN statements BCLOSE ;
	public final void for_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "for_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(33, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:8: ( FOR LOPEN ( ( init )? SEMI ( condition )? SEMI ( assign_st )? ) LCLOSE BOPEN statements BCLOSE )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:10: FOR LOPEN ( ( init )? SEMI ( condition )? SEMI ( assign_st )? ) LCLOSE BOPEN statements BCLOSE
			{
			dbg.location(33,10);
			match(input,FOR,FOLLOW_FOR_in_for_st180); if (state.failed) return;dbg.location(33,14);
			match(input,LOPEN,FOLLOW_LOPEN_in_for_st182); if (state.failed) return;dbg.location(33,19);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:19: ( ( init )? SEMI ( condition )? SEMI ( assign_st )? )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:20: ( init )? SEMI ( condition )? SEMI ( assign_st )?
			{
			dbg.location(33,20);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:20: ( init )?
			int alt6=2;
			try { dbg.enterSubRule(6);
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID||(LA6_0 >= T_CHAR && LA6_0 <= T_STRING)) ) {
				alt6=1;
			}
			} finally {dbg.exitDecision(6);}

			switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:20: init
					{
					dbg.location(33,20);
					pushFollow(FOLLOW_init_in_for_st184);
					init();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
			} finally {dbg.exitSubRule(6);}
			dbg.location(33,26);
			match(input,SEMI,FOLLOW_SEMI_in_for_st187); if (state.failed) return;dbg.location(33,31);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:31: ( condition )?
			int alt7=2;
			try { dbg.enterSubRule(7);
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			int LA7_0 = input.LA(1);
			if ( (LA7_0==FLOAT||LA7_0==ID||LA7_0==INT||LA7_0==LOPEN||LA7_0==SUB) ) {
				alt7=1;
			}
			} finally {dbg.exitDecision(7);}

			switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:31: condition
					{
					dbg.location(33,31);
					pushFollow(FOLLOW_condition_in_for_st189);
					condition();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
			} finally {dbg.exitSubRule(7);}
			dbg.location(33,42);
			match(input,SEMI,FOLLOW_SEMI_in_for_st192); if (state.failed) return;dbg.location(33,47);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:47: ( assign_st )?
			int alt8=2;
			try { dbg.enterSubRule(8);
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			int LA8_0 = input.LA(1);
			if ( (LA8_0==ID||(LA8_0 >= T_CHAR && LA8_0 <= T_STRING)) ) {
				alt8=1;
			}
			} finally {dbg.exitDecision(8);}

			switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:33:47: assign_st
					{
					dbg.location(33,47);
					pushFollow(FOLLOW_assign_st_in_for_st194);
					assign_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
			} finally {dbg.exitSubRule(8);}

			}
			dbg.location(33,58);
			match(input,LCLOSE,FOLLOW_LCLOSE_in_for_st197); if (state.failed) return;dbg.location(33,65);
			match(input,BOPEN,FOLLOW_BOPEN_in_for_st199); if (state.failed) return;dbg.location(33,71);
			pushFollow(FOLLOW_statements_in_for_st201);
			statements();
			state._fsp--;
			if (state.failed) return;dbg.location(33,82);
			match(input,BCLOSE,FOLLOW_BCLOSE_in_for_st203); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(34, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "for_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "for_st"



	// $ANTLR start "init"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:35:1: init : assign_st w ;
	public final void init() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "init");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(35, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:35:6: ( assign_st w )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:35:9: assign_st w
			{
			dbg.location(35,9);
			pushFollow(FOLLOW_assign_st_in_init213);
			assign_st();
			state._fsp--;
			if (state.failed) return;dbg.location(35,19);
			pushFollow(FOLLOW_w_in_init215);
			w();
			state._fsp--;
			if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(36, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "init");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "init"



	// $ANTLR start "w"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:37:1: w : ( ',' assign_st )* ;
	public final void w() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "w");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(37, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:37:3: ( ( ',' assign_st )* )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:37:5: ( ',' assign_st )*
			{
			dbg.location(37,5);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:37:5: ( ',' assign_st )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( (LA9_0==57) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:37:6: ',' assign_st
					{
					dbg.location(37,6);
					match(input,57,FOLLOW_57_in_w226); if (state.failed) return;dbg.location(37,9);
					pushFollow(FOLLOW_assign_st_in_w227);
					assign_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop9;
				}
			}
			} finally {dbg.exitSubRule(9);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(38, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "w");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "w"



	// $ANTLR start "while_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:39:1: while_st : WHILE LOPEN condition LCLOSE BOPEN statements BCLOSE ;
	public final void while_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "while_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(39, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:39:9: ( WHILE LOPEN condition LCLOSE BOPEN statements BCLOSE )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:39:11: WHILE LOPEN condition LCLOSE BOPEN statements BCLOSE
			{
			dbg.location(39,11);
			match(input,WHILE,FOLLOW_WHILE_in_while_st237); if (state.failed) return;dbg.location(39,17);
			match(input,LOPEN,FOLLOW_LOPEN_in_while_st239); if (state.failed) return;dbg.location(39,23);
			pushFollow(FOLLOW_condition_in_while_st241);
			condition();
			state._fsp--;
			if (state.failed) return;dbg.location(39,33);
			match(input,LCLOSE,FOLLOW_LCLOSE_in_while_st243); if (state.failed) return;dbg.location(39,40);
			match(input,BOPEN,FOLLOW_BOPEN_in_while_st245); if (state.failed) return;dbg.location(39,46);
			pushFollow(FOLLOW_statements_in_while_st247);
			statements();
			state._fsp--;
			if (state.failed) return;dbg.location(39,57);
			match(input,BCLOSE,FOLLOW_BCLOSE_in_while_st249); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(40, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "while_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "while_st"



	// $ANTLR start "do_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:42:1: do_st : DO LOPEN condition LCLOSE BOPEN statements BCLOSE ;
	public final void do_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "do_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(42, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:42:7: ( DO LOPEN condition LCLOSE BOPEN statements BCLOSE )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:42:9: DO LOPEN condition LCLOSE BOPEN statements BCLOSE
			{
			dbg.location(42,9);
			match(input,DO,FOLLOW_DO_in_do_st260); if (state.failed) return;dbg.location(42,12);
			match(input,LOPEN,FOLLOW_LOPEN_in_do_st262); if (state.failed) return;dbg.location(42,18);
			pushFollow(FOLLOW_condition_in_do_st264);
			condition();
			state._fsp--;
			if (state.failed) return;dbg.location(42,28);
			match(input,LCLOSE,FOLLOW_LCLOSE_in_do_st266); if (state.failed) return;dbg.location(42,35);
			match(input,BOPEN,FOLLOW_BOPEN_in_do_st268); if (state.failed) return;dbg.location(42,41);
			pushFollow(FOLLOW_statements_in_do_st270);
			statements();
			state._fsp--;
			if (state.failed) return;dbg.location(42,52);
			match(input,BCLOSE,FOLLOW_BCLOSE_in_do_st272); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(43, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "do_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "do_st"



	// $ANTLR start "function_def"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:44:1: function_def : FUNCTION type ID LOPEN def_params LCLOSE BOPEN block ( RETURN ( no | STRING | ID ) SEMI )? BCLOSE ;
	public final void function_def() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "function_def");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(44, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:45:2: ( FUNCTION type ID LOPEN def_params LCLOSE BOPEN block ( RETURN ( no | STRING | ID ) SEMI )? BCLOSE )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:45:4: FUNCTION type ID LOPEN def_params LCLOSE BOPEN block ( RETURN ( no | STRING | ID ) SEMI )? BCLOSE
			{
			dbg.location(45,4);
			match(input,FUNCTION,FOLLOW_FUNCTION_in_function_def282); if (state.failed) return;dbg.location(45,13);
			pushFollow(FOLLOW_type_in_function_def284);
			type();
			state._fsp--;
			if (state.failed) return;dbg.location(45,18);
			match(input,ID,FOLLOW_ID_in_function_def286); if (state.failed) return;dbg.location(45,21);
			match(input,LOPEN,FOLLOW_LOPEN_in_function_def288); if (state.failed) return;dbg.location(45,27);
			pushFollow(FOLLOW_def_params_in_function_def290);
			def_params();
			state._fsp--;
			if (state.failed) return;dbg.location(45,38);
			match(input,LCLOSE,FOLLOW_LCLOSE_in_function_def292); if (state.failed) return;dbg.location(45,45);
			match(input,BOPEN,FOLLOW_BOPEN_in_function_def294); if (state.failed) return;dbg.location(45,51);
			pushFollow(FOLLOW_block_in_function_def296);
			block();
			state._fsp--;
			if (state.failed) return;dbg.location(45,57);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:45:57: ( RETURN ( no | STRING | ID ) SEMI )?
			int alt11=2;
			try { dbg.enterSubRule(11);
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( (LA11_0==RETURN) ) {
				alt11=1;
			}
			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:45:58: RETURN ( no | STRING | ID ) SEMI
					{
					dbg.location(45,58);
					match(input,RETURN,FOLLOW_RETURN_in_function_def299); if (state.failed) return;dbg.location(45,64);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:45:64: ( no | STRING | ID )
					int alt10=3;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					switch ( input.LA(1) ) {
					case FLOAT:
					case INT:
						{
						alt10=1;
						}
						break;
					case STRING:
						{
						alt10=2;
						}
						break;
					case ID:
						{
						alt10=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}
					} finally {dbg.exitDecision(10);}

					switch (alt10) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:45:65: no
							{
							dbg.location(45,65);
							pushFollow(FOLLOW_no_in_function_def301);
							no();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:45:68: STRING
							{
							dbg.location(45,68);
							match(input,STRING,FOLLOW_STRING_in_function_def303); if (state.failed) return;
							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:45:75: ID
							{
							dbg.location(45,75);
							match(input,ID,FOLLOW_ID_in_function_def305); if (state.failed) return;
							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(45,79);
					match(input,SEMI,FOLLOW_SEMI_in_function_def308); if (state.failed) return;
					}
					break;

			}
			} finally {dbg.exitSubRule(11);}
			dbg.location(45,87);
			match(input,BCLOSE,FOLLOW_BCLOSE_in_function_def313); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(46, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "function_def");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "function_def"



	// $ANTLR start "def_params"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:47:1: def_params : ( ( type ID ) m |);
	public final void def_params() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "def_params");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(47, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:48:2: ( ( type ID ) m |)
			int alt12=2;
			try { dbg.enterDecision(12, decisionCanBacktrack[12]);

			int LA12_0 = input.LA(1);
			if ( ((LA12_0 >= T_CHAR && LA12_0 <= T_STRING)) ) {
				alt12=1;
			}
			else if ( (LA12_0==LCLOSE) ) {
				alt12=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(12);}

			switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:48:4: ( type ID ) m
					{
					dbg.location(48,4);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:48:4: ( type ID )
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:48:5: type ID
					{
					dbg.location(48,5);
					pushFollow(FOLLOW_type_in_def_params324);
					type();
					state._fsp--;
					if (state.failed) return;dbg.location(48,10);
					match(input,ID,FOLLOW_ID_in_def_params326); if (state.failed) return;
					}
					dbg.location(48,14);
					pushFollow(FOLLOW_m_in_def_params329);
					m();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:49:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(49, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "def_params");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "def_params"



	// $ANTLR start "m"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:1: m : ( ( ',' ( type ID ) )* |);
	public final void m() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "m");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(50, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:3: ( ( ',' ( type ID ) )* |)
			int alt14=2;
			try { dbg.enterDecision(14, decisionCanBacktrack[14]);

			switch ( input.LA(1) ) {
			case 57:
				{
				alt14=1;
				}
				break;
			case LCLOSE:
				{
				int LA14_2 = input.LA(2);
				if ( (synpred21_s()) ) {
					alt14=1;
				}
				else if ( (true) ) {
					alt14=2;
				}

				}
				break;
			case EOF:
				{
				int LA14_3 = input.LA(2);
				if ( (synpred21_s()) ) {
					alt14=1;
				}
				else if ( (true) ) {
					alt14=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(14);}

			switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:5: ( ',' ( type ID ) )*
					{
					dbg.location(50,5);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:5: ( ',' ( type ID ) )*
					try { dbg.enterSubRule(13);

					loop13:
					while (true) {
						int alt13=2;
						try { dbg.enterDecision(13, decisionCanBacktrack[13]);

						int LA13_0 = input.LA(1);
						if ( (LA13_0==57) ) {
							alt13=1;
						}

						} finally {dbg.exitDecision(13);}

						switch (alt13) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:6: ',' ( type ID )
							{
							dbg.location(50,6);
							match(input,57,FOLLOW_57_in_m340); if (state.failed) return;dbg.location(50,9);
							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:9: ( type ID )
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:10: type ID
							{
							dbg.location(50,10);
							pushFollow(FOLLOW_type_in_m342);
							type();
							state._fsp--;
							if (state.failed) return;dbg.location(50,15);
							match(input,ID,FOLLOW_ID_in_m344); if (state.failed) return;
							}

							}
							break;

						default :
							break loop13;
						}
					}
					} finally {dbg.exitSubRule(13);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:51:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(51, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "m");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "m"



	// $ANTLR start "function_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:53:1: function_st : ID LOPEN params LCLOSE ( SEMI )? ;
	public final void function_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "function_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(53, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:54:2: ( ID LOPEN params LCLOSE ( SEMI )? )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:54:4: ID LOPEN params LCLOSE ( SEMI )?
			{
			dbg.location(54,4);
			match(input,ID,FOLLOW_ID_in_function_st361); if (state.failed) return;dbg.location(54,7);
			match(input,LOPEN,FOLLOW_LOPEN_in_function_st363); if (state.failed) return;dbg.location(54,13);
			pushFollow(FOLLOW_params_in_function_st365);
			params();
			state._fsp--;
			if (state.failed) return;dbg.location(54,20);
			match(input,LCLOSE,FOLLOW_LCLOSE_in_function_st367); if (state.failed) return;dbg.location(54,27);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:54:27: ( SEMI )?
			int alt15=2;
			try { dbg.enterSubRule(15);
			try { dbg.enterDecision(15, decisionCanBacktrack[15]);

			int LA15_0 = input.LA(1);
			if ( (LA15_0==SEMI) ) {
				alt15=1;
			}
			} finally {dbg.exitDecision(15);}

			switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:54:27: SEMI
					{
					dbg.location(54,27);
					match(input,SEMI,FOLLOW_SEMI_in_function_st369); if (state.failed) return;
					}
					break;

			}
			} finally {dbg.exitSubRule(15);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(55, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "function_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "function_st"



	// $ANTLR start "params"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:56:1: params : ( ( e | STRING ) f |);
	public final void params() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "params");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(56, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:56:8: ( ( e | STRING ) f |)
			int alt17=2;
			try { dbg.enterDecision(17, decisionCanBacktrack[17]);

			int LA17_0 = input.LA(1);
			if ( (LA17_0==FLOAT||LA17_0==ID||LA17_0==INT||LA17_0==LOPEN||(LA17_0 >= STRING && LA17_0 <= SUB)) ) {
				alt17=1;
			}
			else if ( (LA17_0==LCLOSE) ) {
				alt17=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(17);}

			switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:56:10: ( e | STRING ) f
					{
					dbg.location(56,10);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:56:10: ( e | STRING )
					int alt16=2;
					try { dbg.enterSubRule(16);
					try { dbg.enterDecision(16, decisionCanBacktrack[16]);

					int LA16_0 = input.LA(1);
					if ( (LA16_0==FLOAT||LA16_0==ID||LA16_0==INT||LA16_0==LOPEN||LA16_0==SUB) ) {
						alt16=1;
					}
					else if ( (LA16_0==STRING) ) {
						alt16=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(16);}

					switch (alt16) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:56:11: e
							{
							dbg.location(56,11);
							pushFollow(FOLLOW_e_in_params380);
							e();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:56:13: STRING
							{
							dbg.location(56,13);
							match(input,STRING,FOLLOW_STRING_in_params382); if (state.failed) return;
							}
							break;

					}
					} finally {dbg.exitSubRule(16);}
					dbg.location(56,21);
					pushFollow(FOLLOW_f_in_params385);
					f();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:57:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(57, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "params");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "params"



	// $ANTLR start "f"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:58:1: f : ( ',' ( e | STRING ) )* ;
	public final void f() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "f");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(58, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:58:3: ( ( ',' ( e | STRING ) )* )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:58:5: ( ',' ( e | STRING ) )*
			{
			dbg.location(58,5);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:58:5: ( ',' ( e | STRING ) )*
			try { dbg.enterSubRule(19);

			loop19:
			while (true) {
				int alt19=2;
				try { dbg.enterDecision(19, decisionCanBacktrack[19]);

				int LA19_0 = input.LA(1);
				if ( (LA19_0==57) ) {
					alt19=1;
				}

				} finally {dbg.exitDecision(19);}

				switch (alt19) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:58:6: ',' ( e | STRING )
					{
					dbg.location(58,6);
					match(input,57,FOLLOW_57_in_f396); if (state.failed) return;dbg.location(58,9);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:58:9: ( e | STRING )
					int alt18=2;
					try { dbg.enterSubRule(18);
					try { dbg.enterDecision(18, decisionCanBacktrack[18]);

					int LA18_0 = input.LA(1);
					if ( (LA18_0==FLOAT||LA18_0==ID||LA18_0==INT||LA18_0==LOPEN||LA18_0==SUB) ) {
						alt18=1;
					}
					else if ( (LA18_0==STRING) ) {
						alt18=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 18, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(18);}

					switch (alt18) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:58:10: e
							{
							dbg.location(58,10);
							pushFollow(FOLLOW_e_in_f398);
							e();
							state._fsp--;
							if (state.failed) return;
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:58:12: STRING
							{
							dbg.location(58,12);
							match(input,STRING,FOLLOW_STRING_in_f400); if (state.failed) return;
							}
							break;

					}
					} finally {dbg.exitSubRule(18);}

					}
					break;

				default :
					break loop19;
				}
			}
			} finally {dbg.exitSubRule(19);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(59, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "f");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "f"



	// $ANTLR start "if_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:61:1: if_st : IF LOPEN condition LCLOSE BOPEN statements BCLOSE ( else_if_st )* ( else_st )? ;
	public final void if_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "if_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(61, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:61:6: ( IF LOPEN condition LCLOSE BOPEN statements BCLOSE ( else_if_st )* ( else_st )? )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:61:9: IF LOPEN condition LCLOSE BOPEN statements BCLOSE ( else_if_st )* ( else_st )?
			{
			dbg.location(61,9);
			match(input,IF,FOLLOW_IF_in_if_st415); if (state.failed) return;dbg.location(61,12);
			match(input,LOPEN,FOLLOW_LOPEN_in_if_st417); if (state.failed) return;dbg.location(61,18);
			pushFollow(FOLLOW_condition_in_if_st419);
			condition();
			state._fsp--;
			if (state.failed) return;dbg.location(61,28);
			match(input,LCLOSE,FOLLOW_LCLOSE_in_if_st421); if (state.failed) return;dbg.location(61,35);
			match(input,BOPEN,FOLLOW_BOPEN_in_if_st423); if (state.failed) return;dbg.location(61,41);
			pushFollow(FOLLOW_statements_in_if_st425);
			statements();
			state._fsp--;
			if (state.failed) return;dbg.location(61,52);
			match(input,BCLOSE,FOLLOW_BCLOSE_in_if_st427); if (state.failed) return;dbg.location(61,59);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:61:59: ( else_if_st )*
			try { dbg.enterSubRule(20);

			loop20:
			while (true) {
				int alt20=2;
				try { dbg.enterDecision(20, decisionCanBacktrack[20]);

				int LA20_0 = input.LA(1);
				if ( (LA20_0==ELIF) ) {
					alt20=1;
				}

				} finally {dbg.exitDecision(20);}

				switch (alt20) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:61:60: else_if_st
					{
					dbg.location(61,60);
					pushFollow(FOLLOW_else_if_st_in_if_st430);
					else_if_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop20;
				}
			}
			} finally {dbg.exitSubRule(20);}
			dbg.location(61,73);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:61:73: ( else_st )?
			int alt21=2;
			try { dbg.enterSubRule(21);
			try { dbg.enterDecision(21, decisionCanBacktrack[21]);

			int LA21_0 = input.LA(1);
			if ( (LA21_0==ELSE) ) {
				alt21=1;
			}
			} finally {dbg.exitDecision(21);}

			switch (alt21) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:61:74: else_st
					{
					dbg.location(61,74);
					pushFollow(FOLLOW_else_st_in_if_st435);
					else_st();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
			} finally {dbg.exitSubRule(21);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(62, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "if_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "if_st"



	// $ANTLR start "else_if_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:64:1: else_if_st : ELIF LOPEN condition LCLOSE BOPEN statements BCLOSE ;
	public final void else_if_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "else_if_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(64, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:65:2: ( ELIF LOPEN condition LCLOSE BOPEN statements BCLOSE )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:65:4: ELIF LOPEN condition LCLOSE BOPEN statements BCLOSE
			{
			dbg.location(65,4);
			match(input,ELIF,FOLLOW_ELIF_in_else_if_st448); if (state.failed) return;dbg.location(65,9);
			match(input,LOPEN,FOLLOW_LOPEN_in_else_if_st450); if (state.failed) return;dbg.location(65,15);
			pushFollow(FOLLOW_condition_in_else_if_st452);
			condition();
			state._fsp--;
			if (state.failed) return;dbg.location(65,25);
			match(input,LCLOSE,FOLLOW_LCLOSE_in_else_if_st454); if (state.failed) return;dbg.location(65,32);
			match(input,BOPEN,FOLLOW_BOPEN_in_else_if_st456); if (state.failed) return;dbg.location(65,38);
			pushFollow(FOLLOW_statements_in_else_if_st458);
			statements();
			state._fsp--;
			if (state.failed) return;dbg.location(65,49);
			match(input,BCLOSE,FOLLOW_BCLOSE_in_else_if_st460); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(66, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "else_if_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "else_if_st"



	// $ANTLR start "else_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:68:1: else_st : ELSE BOPEN statements BCLOSE ;
	public final void else_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "else_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(68, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:68:9: ( ELSE BOPEN statements BCLOSE )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:68:11: ELSE BOPEN statements BCLOSE
			{
			dbg.location(68,11);
			match(input,ELSE,FOLLOW_ELSE_in_else_st472); if (state.failed) return;dbg.location(68,16);
			match(input,BOPEN,FOLLOW_BOPEN_in_else_st474); if (state.failed) return;dbg.location(68,22);
			pushFollow(FOLLOW_statements_in_else_st476);
			statements();
			state._fsp--;
			if (state.failed) return;dbg.location(68,33);
			match(input,BCLOSE,FOLLOW_BCLOSE_in_else_st478); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(69, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "else_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "else_st"



	// $ANTLR start "condition"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:71:1: condition : ( condition2 c | LOPEN condition2 LCLOSE c );
	public final void condition() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "condition");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(71, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:72:2: ( condition2 c | LOPEN condition2 LCLOSE c )
			int alt22=2;
			try { dbg.enterDecision(22, decisionCanBacktrack[22]);

			int LA22_0 = input.LA(1);
			if ( (LA22_0==FLOAT||LA22_0==ID||LA22_0==INT||LA22_0==SUB) ) {
				alt22=1;
			}
			else if ( (LA22_0==LOPEN) ) {
				int LA22_4 = input.LA(2);
				if ( (synpred29_s()) ) {
					alt22=1;
				}
				else if ( (true) ) {
					alt22=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(22);}

			switch (alt22) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:72:4: condition2 c
					{
					dbg.location(72,4);
					pushFollow(FOLLOW_condition2_in_condition490);
					condition2();
					state._fsp--;
					if (state.failed) return;dbg.location(72,15);
					pushFollow(FOLLOW_c_in_condition492);
					c();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:72:19: LOPEN condition2 LCLOSE c
					{
					dbg.location(72,19);
					match(input,LOPEN,FOLLOW_LOPEN_in_condition496); if (state.failed) return;dbg.location(72,25);
					pushFollow(FOLLOW_condition2_in_condition498);
					condition2();
					state._fsp--;
					if (state.failed) return;dbg.location(72,36);
					match(input,LCLOSE,FOLLOW_LCLOSE_in_condition500); if (state.failed) return;dbg.location(72,43);
					pushFollow(FOLLOW_c_in_condition502);
					c();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(73, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "condition");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "condition"



	// $ANTLR start "c"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:1: c : ( ( b_op condition2 )* | ( b_op LOPEN condition2 LCLOSE )* );
	public final void c() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "c");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(74, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:3: ( ( b_op condition2 )* | ( b_op LOPEN condition2 LCLOSE )* )
			int alt25=2;
			try { dbg.enterDecision(25, decisionCanBacktrack[25]);

			switch ( input.LA(1) ) {
			case B_AND:
			case B_OR:
				{
				int LA25_1 = input.LA(2);
				if ( (synpred31_s()) ) {
					alt25=1;
				}
				else if ( (true) ) {
					alt25=2;
				}

				}
				break;
			case SEMI:
				{
				int LA25_2 = input.LA(2);
				if ( (synpred31_s()) ) {
					alt25=1;
				}
				else if ( (true) ) {
					alt25=2;
				}

				}
				break;
			case LCLOSE:
				{
				int LA25_3 = input.LA(2);
				if ( (synpred31_s()) ) {
					alt25=1;
				}
				else if ( (true) ) {
					alt25=2;
				}

				}
				break;
			case EOF:
				{
				int LA25_4 = input.LA(2);
				if ( (synpred31_s()) ) {
					alt25=1;
				}
				else if ( (true) ) {
					alt25=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(25);}

			switch (alt25) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:5: ( b_op condition2 )*
					{
					dbg.location(74,5);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:5: ( b_op condition2 )*
					try { dbg.enterSubRule(23);

					loop23:
					while (true) {
						int alt23=2;
						try { dbg.enterDecision(23, decisionCanBacktrack[23]);

						int LA23_0 = input.LA(1);
						if ( ((LA23_0 >= B_AND && LA23_0 <= B_OR)) ) {
							alt23=1;
						}

						} finally {dbg.exitDecision(23);}

						switch (alt23) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:6: b_op condition2
							{
							dbg.location(74,6);
							pushFollow(FOLLOW_b_op_in_c512);
							b_op();
							state._fsp--;
							if (state.failed) return;dbg.location(74,11);
							pushFollow(FOLLOW_condition2_in_c514);
							condition2();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop23;
						}
					}
					} finally {dbg.exitSubRule(23);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:26: ( b_op LOPEN condition2 LCLOSE )*
					{
					dbg.location(74,26);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:26: ( b_op LOPEN condition2 LCLOSE )*
					try { dbg.enterSubRule(24);

					loop24:
					while (true) {
						int alt24=2;
						try { dbg.enterDecision(24, decisionCanBacktrack[24]);

						int LA24_0 = input.LA(1);
						if ( ((LA24_0 >= B_AND && LA24_0 <= B_OR)) ) {
							alt24=1;
						}

						} finally {dbg.exitDecision(24);}

						switch (alt24) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:27: b_op LOPEN condition2 LCLOSE
							{
							dbg.location(74,27);
							pushFollow(FOLLOW_b_op_in_c521);
							b_op();
							state._fsp--;
							if (state.failed) return;dbg.location(74,32);
							match(input,LOPEN,FOLLOW_LOPEN_in_c523); if (state.failed) return;dbg.location(74,38);
							pushFollow(FOLLOW_condition2_in_c525);
							condition2();
							state._fsp--;
							if (state.failed) return;dbg.location(74,49);
							match(input,LCLOSE,FOLLOW_LCLOSE_in_c527); if (state.failed) return;
							}
							break;

						default :
							break loop24;
						}
					}
					} finally {dbg.exitSubRule(24);}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(75, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "c");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "c"



	// $ANTLR start "b_op"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:77:1: b_op : ( B_AND | B_OR );
	public final void b_op() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "b_op");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(77, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:77:6: ( B_AND | B_OR )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:
			{
			dbg.location(77,6);
			if ( (input.LA(1) >= B_AND && input.LA(1) <= B_OR) ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(78, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "b_op");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "b_op"



	// $ANTLR start "condition2"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:80:1: condition2 : e conOp e ;
	public final void condition2() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "condition2");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(80, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:81:2: ( e conOp e )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:81:4: e conOp e
			{
			dbg.location(81,4);
			pushFollow(FOLLOW_e_in_condition2554);
			e();
			state._fsp--;
			if (state.failed) return;dbg.location(81,6);
			pushFollow(FOLLOW_conOp_in_condition2556);
			conOp();
			state._fsp--;
			if (state.failed) return;dbg.location(81,12);
			pushFollow(FOLLOW_e_in_condition2558);
			e();
			state._fsp--;
			if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(82, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "condition2");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "condition2"



	// $ANTLR start "e"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:84:1: e : ( g ( op g )* ) ;
	public final void e() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "e");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(84, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:84:3: ( ( g ( op g )* ) )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:84:5: ( g ( op g )* )
			{
			dbg.location(84,5);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:84:5: ( g ( op g )* )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:84:6: g ( op g )*
			{
			dbg.location(84,6);
			pushFollow(FOLLOW_g_in_e570);
			g();
			state._fsp--;
			if (state.failed) return;dbg.location(84,8);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:84:8: ( op g )*
			try { dbg.enterSubRule(26);

			loop26:
			while (true) {
				int alt26=2;
				try { dbg.enterDecision(26, decisionCanBacktrack[26]);

				int LA26_0 = input.LA(1);
				if ( (LA26_0==AND||LA26_0==DIVIDE||LA26_0==MULTIPLY||(LA26_0 >= OR && LA26_0 <= REM)||(LA26_0 >= SLL && LA26_0 <= SRL)||LA26_0==SUB||LA26_0==XOR) ) {
					alt26=1;
				}

				} finally {dbg.exitDecision(26);}

				switch (alt26) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:84:9: op g
					{
					dbg.location(84,9);
					pushFollow(FOLLOW_op_in_e573);
					op();
					state._fsp--;
					if (state.failed) return;dbg.location(84,12);
					pushFollow(FOLLOW_g_in_e575);
					g();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop26;
				}
			}
			} finally {dbg.exitSubRule(26);}

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(85, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "e");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "e"



	// $ANTLR start "g"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:1: g : ( ( '-' )? ( ID | no ) ( COPEN e CCLOSE )* | LOPEN g ( op g )* LCLOSE );
	public final void g() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "g");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(88, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:3: ( ( '-' )? ( ID | no ) ( COPEN e CCLOSE )* | LOPEN g ( op g )* LCLOSE )
			int alt31=2;
			try { dbg.enterDecision(31, decisionCanBacktrack[31]);

			int LA31_0 = input.LA(1);
			if ( (LA31_0==FLOAT||LA31_0==ID||LA31_0==INT||LA31_0==SUB) ) {
				alt31=1;
			}
			else if ( (LA31_0==LOPEN) ) {
				alt31=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(31);}

			switch (alt31) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:5: ( '-' )? ( ID | no ) ( COPEN e CCLOSE )*
					{
					dbg.location(88,5);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:5: ( '-' )?
					int alt27=2;
					try { dbg.enterSubRule(27);
					try { dbg.enterDecision(27, decisionCanBacktrack[27]);

					int LA27_0 = input.LA(1);
					if ( (LA27_0==SUB) ) {
						alt27=1;
					}
					} finally {dbg.exitDecision(27);}

					switch (alt27) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:5: '-'
							{
							dbg.location(88,5);
							match(input,SUB,FOLLOW_SUB_in_g591); if (state.failed) return;
							}
							break;

					}
					} finally {dbg.exitSubRule(27);}
					dbg.location(88,9);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:9: ( ID | no )
					int alt28=2;
					try { dbg.enterSubRule(28);
					try { dbg.enterDecision(28, decisionCanBacktrack[28]);

					int LA28_0 = input.LA(1);
					if ( (LA28_0==ID) ) {
						alt28=1;
					}
					else if ( (LA28_0==FLOAT||LA28_0==INT) ) {
						alt28=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 28, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(28);}

					switch (alt28) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:10: ID
							{
							dbg.location(88,10);
							match(input,ID,FOLLOW_ID_in_g594); if (state.failed) return;
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:13: no
							{
							dbg.location(88,13);
							pushFollow(FOLLOW_no_in_g596);
							no();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}
					} finally {dbg.exitSubRule(28);}
					dbg.location(88,16);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:16: ( COPEN e CCLOSE )*
					try { dbg.enterSubRule(29);

					loop29:
					while (true) {
						int alt29=2;
						try { dbg.enterDecision(29, decisionCanBacktrack[29]);

						int LA29_0 = input.LA(1);
						if ( (LA29_0==COPEN) ) {
							alt29=1;
						}

						} finally {dbg.exitDecision(29);}

						switch (alt29) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:17: COPEN e CCLOSE
							{
							dbg.location(88,17);
							match(input,COPEN,FOLLOW_COPEN_in_g599); if (state.failed) return;dbg.location(88,23);
							pushFollow(FOLLOW_e_in_g601);
							e();
							state._fsp--;
							if (state.failed) return;dbg.location(88,25);
							match(input,CCLOSE,FOLLOW_CCLOSE_in_g603); if (state.failed) return;
							}
							break;

						default :
							break loop29;
						}
					}
					} finally {dbg.exitSubRule(29);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:35: LOPEN g ( op g )* LCLOSE
					{
					dbg.location(88,35);
					match(input,LOPEN,FOLLOW_LOPEN_in_g608); if (state.failed) return;dbg.location(88,41);
					pushFollow(FOLLOW_g_in_g610);
					g();
					state._fsp--;
					if (state.failed) return;dbg.location(88,43);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:43: ( op g )*
					try { dbg.enterSubRule(30);

					loop30:
					while (true) {
						int alt30=2;
						try { dbg.enterDecision(30, decisionCanBacktrack[30]);

						int LA30_0 = input.LA(1);
						if ( (LA30_0==AND||LA30_0==DIVIDE||LA30_0==MULTIPLY||(LA30_0 >= OR && LA30_0 <= REM)||(LA30_0 >= SLL && LA30_0 <= SRL)||LA30_0==SUB||LA30_0==XOR) ) {
							alt30=1;
						}

						} finally {dbg.exitDecision(30);}

						switch (alt30) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:88:44: op g
							{
							dbg.location(88,44);
							pushFollow(FOLLOW_op_in_g613);
							op();
							state._fsp--;
							if (state.failed) return;dbg.location(88,47);
							pushFollow(FOLLOW_g_in_g615);
							g();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop30;
						}
					}
					} finally {dbg.exitSubRule(30);}
					dbg.location(88,51);
					match(input,LCLOSE,FOLLOW_LCLOSE_in_g619); if (state.failed) return;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(89, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "g");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "g"



	// $ANTLR start "assign_st"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:91:1: assign_st : ( type ID r | ID ( COPEN e CCLOSE )* r );
	public final void assign_st() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "assign_st");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(91, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:92:2: ( type ID r | ID ( COPEN e CCLOSE )* r )
			int alt33=2;
			try { dbg.enterDecision(33, decisionCanBacktrack[33]);

			int LA33_0 = input.LA(1);
			if ( ((LA33_0 >= T_CHAR && LA33_0 <= T_STRING)) ) {
				alt33=1;
			}
			else if ( (LA33_0==ID) ) {
				alt33=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(33);}

			switch (alt33) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:92:4: type ID r
					{
					dbg.location(92,4);
					pushFollow(FOLLOW_type_in_assign_st631);
					type();
					state._fsp--;
					if (state.failed) return;dbg.location(92,10);
					match(input,ID,FOLLOW_ID_in_assign_st634); if (state.failed) return;dbg.location(92,13);
					pushFollow(FOLLOW_r_in_assign_st636);
					r();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:92:17: ID ( COPEN e CCLOSE )* r
					{
					dbg.location(92,17);
					match(input,ID,FOLLOW_ID_in_assign_st640); if (state.failed) return;dbg.location(92,20);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:92:20: ( COPEN e CCLOSE )*
					try { dbg.enterSubRule(32);

					loop32:
					while (true) {
						int alt32=2;
						try { dbg.enterDecision(32, decisionCanBacktrack[32]);

						int LA32_0 = input.LA(1);
						if ( (LA32_0==COPEN) ) {
							alt32=1;
						}

						} finally {dbg.exitDecision(32);}

						switch (alt32) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:92:21: COPEN e CCLOSE
							{
							dbg.location(92,21);
							match(input,COPEN,FOLLOW_COPEN_in_assign_st643); if (state.failed) return;dbg.location(92,27);
							pushFollow(FOLLOW_e_in_assign_st645);
							e();
							state._fsp--;
							if (state.failed) return;dbg.location(92,29);
							match(input,CCLOSE,FOLLOW_CCLOSE_in_assign_st647); if (state.failed) return;
							}
							break;

						default :
							break loop32;
						}
					}
					} finally {dbg.exitSubRule(32);}
					dbg.location(92,38);
					pushFollow(FOLLOW_r_in_assign_st651);
					r();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(93, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "assign_st");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "assign_st"



	// $ANTLR start "r"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:95:1: r : ( ASSIGN v |);
	public final void r() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "r");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(95, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:95:3: ( ASSIGN v |)
			int alt34=2;
			try { dbg.enterDecision(34, decisionCanBacktrack[34]);

			int LA34_0 = input.LA(1);
			if ( (LA34_0==ASSIGN) ) {
				alt34=1;
			}
			else if ( (LA34_0==EOF||LA34_0==LCLOSE||LA34_0==SEMI||LA34_0==57) ) {
				alt34=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(34);}

			switch (alt34) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:95:5: ASSIGN v
					{
					dbg.location(95,5);
					match(input,ASSIGN,FOLLOW_ASSIGN_in_r663); if (state.failed) return;dbg.location(95,12);
					pushFollow(FOLLOW_v_in_r665);
					v();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:96:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(96, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "r");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "r"



	// $ANTLR start "v"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:98:1: v : ( '{' e n '}' | e | '{' v ( ',' v )* '}' );
	public final void v() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "v");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(98, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:98:3: ( '{' e n '}' | e | '{' v ( ',' v )* '}' )
			int alt36=3;
			try { dbg.enterDecision(36, decisionCanBacktrack[36]);

			int LA36_0 = input.LA(1);
			if ( (LA36_0==BOPEN) ) {
				int LA36_1 = input.LA(2);
				if ( (synpred43_s()) ) {
					alt36=1;
				}
				else if ( (true) ) {
					alt36=3;
				}

			}
			else if ( (LA36_0==FLOAT||LA36_0==ID||LA36_0==INT||LA36_0==LOPEN||LA36_0==SUB) ) {
				alt36=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(36);}

			switch (alt36) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:98:5: '{' e n '}'
					{
					dbg.location(98,5);
					match(input,BOPEN,FOLLOW_BOPEN_in_v678); if (state.failed) return;dbg.location(98,8);
					pushFollow(FOLLOW_e_in_v679);
					e();
					state._fsp--;
					if (state.failed) return;dbg.location(98,10);
					pushFollow(FOLLOW_n_in_v681);
					n();
					state._fsp--;
					if (state.failed) return;dbg.location(98,11);
					match(input,BCLOSE,FOLLOW_BCLOSE_in_v682); if (state.failed) return;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:98:15: e
					{
					dbg.location(98,15);
					pushFollow(FOLLOW_e_in_v684);
					e();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:98:19: '{' v ( ',' v )* '}'
					{
					dbg.location(98,19);
					match(input,BOPEN,FOLLOW_BOPEN_in_v688); if (state.failed) return;dbg.location(98,23);
					pushFollow(FOLLOW_v_in_v690);
					v();
					state._fsp--;
					if (state.failed) return;dbg.location(98,24);
					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:98:24: ( ',' v )*
					try { dbg.enterSubRule(35);

					loop35:
					while (true) {
						int alt35=2;
						try { dbg.enterDecision(35, decisionCanBacktrack[35]);

						int LA35_0 = input.LA(1);
						if ( (LA35_0==57) ) {
							alt35=1;
						}

						} finally {dbg.exitDecision(35);}

						switch (alt35) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:98:25: ',' v
							{
							dbg.location(98,25);
							match(input,57,FOLLOW_57_in_v692); if (state.failed) return;dbg.location(98,29);
							pushFollow(FOLLOW_v_in_v694);
							v();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							break loop35;
						}
					}
					} finally {dbg.exitSubRule(35);}
					dbg.location(98,33);
					match(input,BCLOSE,FOLLOW_BCLOSE_in_v698); if (state.failed) return;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(99, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "v");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "v"



	// $ANTLR start "n"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:101:1: n : ( ',' e )* ;
	public final void n() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "n");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(101, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:101:3: ( ( ',' e )* )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:101:5: ( ',' e )*
			{
			dbg.location(101,5);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:101:5: ( ',' e )*
			try { dbg.enterSubRule(37);

			loop37:
			while (true) {
				int alt37=2;
				try { dbg.enterDecision(37, decisionCanBacktrack[37]);

				int LA37_0 = input.LA(1);
				if ( (LA37_0==57) ) {
					alt37=1;
				}

				} finally {dbg.exitDecision(37);}

				switch (alt37) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:101:6: ',' e
					{
					dbg.location(101,6);
					match(input,57,FOLLOW_57_in_n710); if (state.failed) return;dbg.location(101,10);
					pushFollow(FOLLOW_e_in_n712);
					e();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop37;
				}
			}
			} finally {dbg.exitSubRule(37);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(102, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "n");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "n"



	// $ANTLR start "type"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:104:1: type : type1 ( COPEN CCLOSE )* ;
	public final void type() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(104, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:104:6: ( type1 ( COPEN CCLOSE )* )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:104:8: type1 ( COPEN CCLOSE )*
			{
			dbg.location(104,8);
			pushFollow(FOLLOW_type1_in_type724);
			type1();
			state._fsp--;
			if (state.failed) return;dbg.location(104,14);
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:104:14: ( COPEN CCLOSE )*
			try { dbg.enterSubRule(38);

			loop38:
			while (true) {
				int alt38=2;
				try { dbg.enterDecision(38, decisionCanBacktrack[38]);

				int LA38_0 = input.LA(1);
				if ( (LA38_0==COPEN) ) {
					alt38=1;
				}

				} finally {dbg.exitDecision(38);}

				switch (alt38) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:104:15: COPEN CCLOSE
					{
					dbg.location(104,15);
					match(input,COPEN,FOLLOW_COPEN_in_type727); if (state.failed) return;dbg.location(104,21);
					match(input,CCLOSE,FOLLOW_CCLOSE_in_type729); if (state.failed) return;
					}
					break;

				default :
					break loop38;
				}
			}
			} finally {dbg.exitSubRule(38);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(105, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type"



	// $ANTLR start "type1"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:107:1: type1 : ( T_INT | T_FLOAT | T_CHAR | T_STRING );
	public final void type1() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "type1");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(107, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:107:7: ( T_INT | T_FLOAT | T_CHAR | T_STRING )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:
			{
			dbg.location(107,7);
			if ( (input.LA(1) >= T_CHAR && input.LA(1) <= T_STRING) ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(108, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type1");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type1"



	// $ANTLR start "no"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:110:1: no : ( INT | FLOAT );
	public final void no() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "no");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(110, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:110:4: ( INT | FLOAT )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:
			{
			dbg.location(110,4);
			if ( input.LA(1)==FLOAT||input.LA(1)==INT ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(111, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "no");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "no"



	// $ANTLR start "op"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:112:1: op : ( POWER | REM | PLUS | SUB | MULTIPLY | DIVIDE | SLL | SRL | AND | OR | XOR );
	public final void op() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "op");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(112, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:112:4: ( POWER | REM | PLUS | SUB | MULTIPLY | DIVIDE | SLL | SRL | AND | OR | XOR )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:
			{
			dbg.location(112,4);
			if ( input.LA(1)==AND||input.LA(1)==DIVIDE||input.LA(1)==MULTIPLY||(input.LA(1) >= OR && input.LA(1) <= REM)||(input.LA(1) >= SLL && input.LA(1) <= SRL)||input.LA(1)==SUB||input.LA(1)==XOR ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(113, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "op");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "op"



	// $ANTLR start "conOp"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:115:1: conOp : ( NEQ | EQ | GT | GEQ | LT | LEQ | B_AND | B_OR );
	public final void conOp() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "conOp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(115, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:115:7: ( NEQ | EQ | GT | GEQ | LT | LEQ | B_AND | B_OR )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:
			{
			dbg.location(115,7);
			if ( (input.LA(1) >= B_AND && input.LA(1) <= B_OR)||input.LA(1)==EQ||(input.LA(1) >= GEQ && input.LA(1) <= GT)||input.LA(1)==LEQ||input.LA(1)==LT||input.LA(1)==NEQ ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(116, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "conOp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "conOp"



	// $ANTLR start "s"
	// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:119:1: s : ( ID | INT | FLOAT | STRING | CHAR | SWITCH | CASE | ELIF | ELSE | WHILE | DO | FOR | FUNCTION | RETURN | T_INT | T_FLOAT | T_CHAR | T_STRING | SEMI | POWER | REM | PLUS | SUB | MULTIPLY | DIVIDE | ASSIGN | SLL | SRL | AND | OR | XOR | B_AND | B_OR | LOPEN | LCLOSE | BOPEN | BCLOSE | EQ | GT | GEQ | LT | LEQ | NEQ | COPEN | CCLOSE );
	public final void s() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "s");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(119, 0);

		try {
			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:119:3: ( ID | INT | FLOAT | STRING | CHAR | SWITCH | CASE | ELIF | ELSE | WHILE | DO | FOR | FUNCTION | RETURN | T_INT | T_FLOAT | T_CHAR | T_STRING | SEMI | POWER | REM | PLUS | SUB | MULTIPLY | DIVIDE | ASSIGN | SLL | SRL | AND | OR | XOR | B_AND | B_OR | LOPEN | LCLOSE | BOPEN | BCLOSE | EQ | GT | GEQ | LT | LEQ | NEQ | COPEN | CCLOSE )
			dbg.enterAlt(1);

			// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:
			{
			dbg.location(119,3);
			if ( (input.LA(1) >= AND && input.LA(1) <= CHAR)||(input.LA(1) >= COPEN && input.LA(1) <= EQ)||(input.LA(1) >= FLOAT && input.LA(1) <= GT)||input.LA(1)==ID||(input.LA(1) >= INT && input.LA(1) <= NEQ)||(input.LA(1) >= OR && input.LA(1) <= T_STRING)||input.LA(1)==WHILE||input.LA(1)==XOR ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(122, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "s");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "s"

	// $ANTLR start synpred4_s
	public final void synpred4_s_fragment() throws RecognitionException {
		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:21:14: ( statement )
		dbg.enterAlt(1);

		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:21:14: statement
		{
		dbg.location(21,14);
		pushFollow(FOLLOW_statement_in_synpred4_s87);
		statement();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred4_s

	// $ANTLR start synpred21_s
	public final void synpred21_s_fragment() throws RecognitionException {
		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:5: ( ( ',' ( type ID ) )* )
		dbg.enterAlt(1);

		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:5: ( ',' ( type ID ) )*
		{
		dbg.location(50,5);
		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:5: ( ',' ( type ID ) )*
		try { dbg.enterSubRule(40);

		loop40:
		while (true) {
			int alt40=2;
			try { dbg.enterDecision(40, decisionCanBacktrack[40]);

			int LA40_0 = input.LA(1);
			if ( (LA40_0==57) ) {
				alt40=1;
			}

			} finally {dbg.exitDecision(40);}

			switch (alt40) {
			case 1 :
				dbg.enterAlt(1);

				// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:6: ',' ( type ID )
				{
				dbg.location(50,6);
				match(input,57,FOLLOW_57_in_synpred21_s340); if (state.failed) return;dbg.location(50,9);
				// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:9: ( type ID )
				dbg.enterAlt(1);

				// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:50:10: type ID
				{
				dbg.location(50,10);
				pushFollow(FOLLOW_type_in_synpred21_s342);
				type();
				state._fsp--;
				if (state.failed) return;dbg.location(50,15);
				match(input,ID,FOLLOW_ID_in_synpred21_s344); if (state.failed) return;
				}

				}
				break;

			default :
				break loop40;
			}
		}
		} finally {dbg.exitSubRule(40);}

		}

	}
	// $ANTLR end synpred21_s

	// $ANTLR start synpred29_s
	public final void synpred29_s_fragment() throws RecognitionException {
		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:72:4: ( condition2 c )
		dbg.enterAlt(1);

		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:72:4: condition2 c
		{
		dbg.location(72,4);
		pushFollow(FOLLOW_condition2_in_synpred29_s490);
		condition2();
		state._fsp--;
		if (state.failed) return;dbg.location(72,15);
		pushFollow(FOLLOW_c_in_synpred29_s492);
		c();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred29_s

	// $ANTLR start synpred31_s
	public final void synpred31_s_fragment() throws RecognitionException {
		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:5: ( ( b_op condition2 )* )
		dbg.enterAlt(1);

		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:5: ( b_op condition2 )*
		{
		dbg.location(74,5);
		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:5: ( b_op condition2 )*
		try { dbg.enterSubRule(43);

		loop43:
		while (true) {
			int alt43=2;
			try { dbg.enterDecision(43, decisionCanBacktrack[43]);

			int LA43_0 = input.LA(1);
			if ( ((LA43_0 >= B_AND && LA43_0 <= B_OR)) ) {
				alt43=1;
			}

			} finally {dbg.exitDecision(43);}

			switch (alt43) {
			case 1 :
				dbg.enterAlt(1);

				// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:74:6: b_op condition2
				{
				dbg.location(74,6);
				pushFollow(FOLLOW_b_op_in_synpred31_s512);
				b_op();
				state._fsp--;
				if (state.failed) return;dbg.location(74,11);
				pushFollow(FOLLOW_condition2_in_synpred31_s514);
				condition2();
				state._fsp--;
				if (state.failed) return;
				}
				break;

			default :
				break loop43;
			}
		}
		} finally {dbg.exitSubRule(43);}

		}

	}
	// $ANTLR end synpred31_s

	// $ANTLR start synpred43_s
	public final void synpred43_s_fragment() throws RecognitionException {
		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:98:5: ( '{' e n '}' )
		dbg.enterAlt(1);

		// C:\\Users\\Admin\\OneDrive\\Desktop\\Java stuff\\antlr-team-project\\grammar\\s.g:98:5: '{' e n '}'
		{
		dbg.location(98,5);
		match(input,BOPEN,FOLLOW_BOPEN_in_synpred43_s678); if (state.failed) return;dbg.location(98,8);
		pushFollow(FOLLOW_e_in_synpred43_s679);
		e();
		state._fsp--;
		if (state.failed) return;dbg.location(98,10);
		pushFollow(FOLLOW_n_in_synpred43_s681);
		n();
		state._fsp--;
		if (state.failed) return;dbg.location(98,11);
		match(input,BCLOSE,FOLLOW_BCLOSE_in_synpred43_s682); if (state.failed) return;
		}

	}
	// $ANTLR end synpred43_s

	// Delegated rules

	public final boolean synpred29_s() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred29_s_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_s() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred4_s_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred21_s() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred21_s_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred43_s() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred43_s_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred31_s() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred31_s_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_blocks_in_start37 = new BitSet(new long[]{0x005F000031810080L});
	public static final BitSet FOLLOW_EOF_in_start40 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_def_in_blocks50 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOPEN_in_blocks53 = new BitSet(new long[]{0x005F000030810000L});
	public static final BitSet FOLLOW_block_in_blocks55 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_blocks57 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_blocks61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_block72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements85 = new BitSet(new long[]{0x005F000030810002L});
	public static final BitSet FOLLOW_statement_in_statements87 = new BitSet(new long[]{0x005F000030810002L});
	public static final BitSet FOLLOW_assign_st_in_statement100 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_statement102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_st_in_statement106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_st_in_statement110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_st_in_statement114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_do_st_in_statement117 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_st_in_statement120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_switch_st_in_statement123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SWITCH_in_switch_st135 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_switch_st137 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_ID_in_switch_st139 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_switch_st141 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BOPEN_in_switch_st143 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_case_st_in_switch_st145 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_BCLOSE_in_switch_st148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CASE_in_case_st158 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_case_st160 = new BitSet(new long[]{0x0000000040400000L});
	public static final BitSet FOLLOW_no_in_case_st162 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_case_st164 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BOPEN_in_case_st166 = new BitSet(new long[]{0x005F000030810000L});
	public static final BitSet FOLLOW_statements_in_case_st168 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_case_st170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_for_st180 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_for_st182 = new BitSet(new long[]{0x001E080010000000L});
	public static final BitSet FOLLOW_init_in_for_st184 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_for_st187 = new BitSet(new long[]{0x0000880250400000L});
	public static final BitSet FOLLOW_condition_in_for_st189 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_for_st192 = new BitSet(new long[]{0x001E000090000000L});
	public static final BitSet FOLLOW_assign_st_in_for_st194 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_for_st197 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BOPEN_in_for_st199 = new BitSet(new long[]{0x005F000030810000L});
	public static final BitSet FOLLOW_statements_in_for_st201 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_for_st203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_st_in_init213 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_w_in_init215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_w226 = new BitSet(new long[]{0x001E000010000000L});
	public static final BitSet FOLLOW_assign_st_in_w227 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_WHILE_in_while_st237 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_while_st239 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_condition_in_while_st241 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_while_st243 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BOPEN_in_while_st245 = new BitSet(new long[]{0x005F000030810000L});
	public static final BitSet FOLLOW_statements_in_while_st247 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_while_st249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DO_in_do_st260 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_do_st262 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_condition_in_do_st264 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_do_st266 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BOPEN_in_do_st268 = new BitSet(new long[]{0x005F000030810000L});
	public static final BitSet FOLLOW_statements_in_do_st270 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_do_st272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_in_function_def282 = new BitSet(new long[]{0x001E000000000000L});
	public static final BitSet FOLLOW_type_in_function_def284 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_ID_in_function_def286 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_function_def288 = new BitSet(new long[]{0x001E000080000000L});
	public static final BitSet FOLLOW_def_params_in_function_def290 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_function_def292 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BOPEN_in_function_def294 = new BitSet(new long[]{0x005F000030810000L});
	public static final BitSet FOLLOW_block_in_function_def296 = new BitSet(new long[]{0x0000040000000040L});
	public static final BitSet FOLLOW_RETURN_in_function_def299 = new BitSet(new long[]{0x0000400050400000L});
	public static final BitSet FOLLOW_no_in_function_def301 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_STRING_in_function_def303 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_ID_in_function_def305 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_SEMI_in_function_def308 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_function_def313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_def_params324 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_ID_in_def_params326 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_m_in_def_params329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_m340 = new BitSet(new long[]{0x001E000000000000L});
	public static final BitSet FOLLOW_type_in_m342 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_ID_in_m344 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_ID_in_function_st361 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_function_st363 = new BitSet(new long[]{0x0000C002D0400000L});
	public static final BitSet FOLLOW_params_in_function_st365 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_function_st367 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_SEMI_in_function_st369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_e_in_params380 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_STRING_in_params382 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_f_in_params385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_f396 = new BitSet(new long[]{0x0000C00250400000L});
	public static final BitSet FOLLOW_e_in_f398 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_STRING_in_f400 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_IF_in_if_st415 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_if_st417 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_condition_in_if_st419 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_if_st421 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BOPEN_in_if_st423 = new BitSet(new long[]{0x005F000030810000L});
	public static final BitSet FOLLOW_statements_in_if_st425 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_if_st427 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_else_if_st_in_if_st430 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_else_st_in_if_st435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELIF_in_else_if_st448 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_else_if_st450 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_condition_in_else_if_st452 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_else_if_st454 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BOPEN_in_else_if_st456 = new BitSet(new long[]{0x005F000030810000L});
	public static final BitSet FOLLOW_statements_in_else_if_st458 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_else_if_st460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_else_st472 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BOPEN_in_else_st474 = new BitSet(new long[]{0x005F000030810000L});
	public static final BitSet FOLLOW_statements_in_else_st476 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_else_st478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition2_in_condition490 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_c_in_condition492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOPEN_in_condition496 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_condition2_in_condition498 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_condition500 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_c_in_condition502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_b_op_in_c512 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_condition2_in_c514 = new BitSet(new long[]{0x0000000000000302L});
	public static final BitSet FOLLOW_b_op_in_c521 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LOPEN_in_c523 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_condition2_in_c525 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LCLOSE_in_c527 = new BitSet(new long[]{0x0000000000000302L});
	public static final BitSet FOLLOW_e_in_condition2554 = new BitSet(new long[]{0x0000001506080300L});
	public static final BitSet FOLLOW_conOp_in_condition2556 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_e_in_condition2558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_g_in_e570 = new BitSet(new long[]{0x0100B3C800008012L});
	public static final BitSet FOLLOW_op_in_e573 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_g_in_e575 = new BitSet(new long[]{0x0100B3C800008012L});
	public static final BitSet FOLLOW_SUB_in_g591 = new BitSet(new long[]{0x0000000050400000L});
	public static final BitSet FOLLOW_ID_in_g594 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_no_in_g596 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_COPEN_in_g599 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_e_in_g601 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CCLOSE_in_g603 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_LOPEN_in_g608 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_g_in_g610 = new BitSet(new long[]{0x0100B3C880008010L});
	public static final BitSet FOLLOW_op_in_g613 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_g_in_g615 = new BitSet(new long[]{0x0100B3C880008010L});
	public static final BitSet FOLLOW_LCLOSE_in_g619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_assign_st631 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_ID_in_assign_st634 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_r_in_assign_st636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assign_st640 = new BitSet(new long[]{0x0000000000004020L});
	public static final BitSet FOLLOW_COPEN_in_assign_st643 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_e_in_assign_st645 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CCLOSE_in_assign_st647 = new BitSet(new long[]{0x0000000000004020L});
	public static final BitSet FOLLOW_r_in_assign_st651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_r663 = new BitSet(new long[]{0x0000800250400080L});
	public static final BitSet FOLLOW_v_in_r665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOPEN_in_v678 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_e_in_v679 = new BitSet(new long[]{0x0200000000000040L});
	public static final BitSet FOLLOW_n_in_v681 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_v682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_e_in_v684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOPEN_in_v688 = new BitSet(new long[]{0x0000800250400080L});
	public static final BitSet FOLLOW_v_in_v690 = new BitSet(new long[]{0x0200000000000040L});
	public static final BitSet FOLLOW_57_in_v692 = new BitSet(new long[]{0x0000800250400080L});
	public static final BitSet FOLLOW_v_in_v694 = new BitSet(new long[]{0x0200000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_v698 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_n710 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_e_in_n712 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_type1_in_type724 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_COPEN_in_type727 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CCLOSE_in_type729 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_statement_in_synpred4_s87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred21_s340 = new BitSet(new long[]{0x001E000000000000L});
	public static final BitSet FOLLOW_type_in_synpred21_s342 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_ID_in_synpred21_s344 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_condition2_in_synpred29_s490 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_c_in_synpred29_s492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_b_op_in_synpred31_s512 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_condition2_in_synpred31_s514 = new BitSet(new long[]{0x0000000000000302L});
	public static final BitSet FOLLOW_BOPEN_in_synpred43_s678 = new BitSet(new long[]{0x0000800250400000L});
	public static final BitSet FOLLOW_e_in_synpred43_s679 = new BitSet(new long[]{0x0200000000000040L});
	public static final BitSet FOLLOW_n_in_synpred43_s681 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_BCLOSE_in_synpred43_s682 = new BitSet(new long[]{0x0000000000000002L});
}
