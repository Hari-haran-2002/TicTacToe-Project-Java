import java.util.*;
class TicTacToe{
	static char[][] board;
	public TicTacToe() {
		board = new char [3][3];
		initBoard();
	}
	void initBoard() {
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
		}
	}
	static void dispBoard() {


		System.out.println("--------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("--------------");
		}
		
	}
	static void placeMark(int row,int col, char mark) {
		if(row>=0 && row<=2 && col>=0 && col<=2)
		{
			board[row][col]=mark;
		}
		else
		{
			System.out.println("Invalid Position");
		}
		
	}
	static boolean checkColWin()
	{
		for(int j=0;j<=2;j++) {
		if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
			return true;
		}
		
		}
		return false;
	}
		
	static boolean checkRowWin()
	{
		for(int i =0;i<=2;i++) {
			if(board[i][0] !=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2] ) {
				return true;
			}
			
		}
		return false;
		
	
	}
	static boolean checkDiagonalWin()
	{
		if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1] ==board[2][2]) {
			return true;
		}
		else {
			return false;
		}
	}
	
		}

class Players{
	String name;
	char mark;
	Players(String name,char mark) {
		this.name=name;
		this.mark=mark;
		
	}
	void makeMove() {
		 Scanner scan = new Scanner(System.in) ;
		 int row;
		 int col;
			
		 do{
				System.out.println("Enter row and columns ");
				row = scan.nextInt();
			    col= scan.nextInt();
			} while(!isValidMove(row, col));
			
			TicTacToe.placeMark(row, col, mark);
			scan.close();
			
		}
	
	boolean isValidMove(int row,int col) {
		if(row>=0 && row<=2 && col>=0 && col<=2) {
			if(TicTacToe.board[row][col]==' ') {
				return true;
			}
			

		}
		return false;
		
	}
	
			
		
			
		
		
	}
	
	

public class TicTacgame{
	public static void main(String args[]) {
		
		
		Players p1 = new Players("Ram",'X');
		Players p2 = new Players("Gopi",'O');
		Players cp;
		cp=p1; 
		while(true) {
			System.out.println(cp.name + " turn");
			cp.makeMove();
			TicTacToe.dispBoard();
			if(TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagonalWin()) {
				System.out.println(cp.name + "won");
				break;
			}
			else {
				if(cp==p1) {
					cp=p2;
				}
				else {
					cp=p1;
				}
			}
		}
		
		
		
	}
}