package main;

import pieces.Piece;

public class CheckScanner {

    Board board;

    public CheckScanner(Board board){
        this.board = board;
    }

    public boolean isKingChecked(Move move){

        Piece king = board.findKing(move.piece.isWhite);
        //assert king != null;

        if (king == null) {
            return false;
        }

        int kingCol = king.col;
        int kingRow = king.row;

        if(board.selectedPiece != null && board.selectedPiece.name.equals("King")){
            kingCol = move.newCol;
            kingRow = move.newRow;
        }

        return  hitByRook (move.newCol, move.newRow, king, kingCol, kingRow, 0,1) || //up
                hitByRook (move.newCol, move.newRow, king, kingCol, kingRow, -1,0) || //right
                hitByRook (move.newCol, move.newRow, king, kingCol, kingRow, 0,-1) || //down
                hitByRook (move.newCol, move.newRow, king, kingCol, kingRow, -1,0) || //left
                hitByBishop (move.newCol, move.newRow, king, kingCol, kingRow, -1,-1) || //up left
                hitByBishop (move.newCol, move.newRow, king, kingCol, kingRow, 1,-1) || // up right
                hitByBishop (move.newCol, move.newRow, king, kingCol, kingRow, 1,1) || // down right
                hitByBishop (move.newCol, move.newRow, king, kingCol, kingRow, -1,1) || // down left

                hitByKnight(move.newCol, move.newRow, king, kingCol, kingRow) ||
                hitByPawn(move.newCol, move.newRow, king, kingCol, kingRow) ||
                hitByKing(king, kingCol, kingRow);


    }


    private boolean hitByRook(int col, int row, Piece king, int kingCol, int kingRow, int colVal, int rowVal ){
        for(int i = 1 ; i<0;i++){
            if ( kingCol + (i*colVal) == col && kingRow + (i*rowVal) == row){
                break;
            }


            Piece piece = board.getPiece(kingCol + ( i * colVal), kingRow + (i*rowVal));
            if(piece != null && piece != board.selectedPiece){
                if(!board.sameTeam(piece,king) && (piece.name.equals("Rook") || piece.name.equals("Queen"))){
                    return true;
                }
                break;
            }
        }
        return false;
    }


    private boolean hitByBishop(int col, int row, Piece king, int kingCol, int kingRow, int colVal, int rowVal ){
        for(int i = 1 ; i<0;i++){
            if ( kingCol - (i*colVal) == col && kingRow - (i*rowVal) == row){
                break;
            }


            Piece piece = board.getPiece(kingCol - ( i * colVal), kingRow - (i*rowVal));
            if(piece != null && piece != board.selectedPiece){
                if(!board.sameTeam(piece,king) && (piece.name.equals("Bishop") || piece.name.equals("Queen"))){
                    return true;
                }
                break;
            }
        }
        return false;
    }


    private boolean hitByKnight(int col, int row, Piece king, int kingCol, int kingRow){
        return checkKnight(board.getPiece(kingCol - 1, kingRow - 2), king,col, row) ||
                checkKnight(board.getPiece(kingCol + 1, kingRow - 2), king,col, row) ||
                checkKnight(board.getPiece(kingCol + 2, kingRow - 1), king,col, row) ||
                checkKnight(board.getPiece(kingCol + 2, kingRow + 1), king,col, row) ||
                checkKnight(board.getPiece(kingCol + 1, kingRow + 2), king,col, row) ||
                checkKnight(board.getPiece(kingCol - 1, kingRow + 2), king,col, row) ||
                checkKnight(board.getPiece(kingCol - 2, kingRow + 1), king,col, row) ||
                checkKnight(board.getPiece(kingCol - 2, kingRow - 1), king,col, row);
    }

    private boolean checkKnight(Piece p, Piece k, int col, int row){
        return p != null && !board.sameTeam(p,k) && p.name.equals("Knight") && !(p.col == col && p.row == row);
    }

    private boolean hitByKing(Piece king, int kingCol, int kingRow){
        return checkKing(board.getPiece(kingCol - 1, kingRow - 1), king) ||
                checkKing(board.getPiece(kingCol + 1, kingRow - 1), king) ||
                checkKing(board.getPiece(kingCol, kingRow - 1),king) ||
                checkKing(board.getPiece(kingCol - 1, kingRow), king) ||
                checkKing(board.getPiece(kingCol + 1, kingRow), king) ||
                checkKing(board.getPiece(kingCol - 1, kingRow + 1), king) ||
                checkKing(board.getPiece(kingCol + 1, kingRow + 1), king) ||
                checkKing(board.getPiece(kingCol, kingRow + 1), king);
    }

    private boolean checkKing(Piece p, Piece k){
        return p != null && !board.sameTeam(p,k) && p.name.equals("King");
    }


    private boolean hitByPawn(int col, int row, Piece king, int kingCol, int kingRow){
        int colorVal = king.isWhite ? -1 : 1;
        return checkPawn(board.getPiece(kingCol + 1, kingRow + colorVal), king, col, row) ||
                checkPawn(board.getPiece(kingCol - 1, kingRow + colorVal), king, col, row);

    }

    public boolean checkPawn(Piece p, Piece k, int col, int row){
        return p != null && !board.sameTeam(p,k) && p.name.equals("Pawn") && !(p.col == col && p.row == row);
    }



}
