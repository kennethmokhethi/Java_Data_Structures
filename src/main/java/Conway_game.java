public class Conway_game {
    //Attribute
    private int[][] game_world = new int[10][10];
    private char char_world[] = {'+','#'};
    private int[][] copy_of_game_world = new int[10][10];

    //Getter and setter


    public int[][] getGame_world() {
        return game_world;
    }

    public void setGame_world(int[][] game_world) {
        this.game_world = game_world;
    }

    public char[] getChar_world() {
        return char_world;
    }

    public void setChar_world(char[] char_world) {
        this.char_world = char_world;
    }


    public void initialise_game(char[][] input){
         for(int r = 0;r < 10;r++){
             for(int c = 0;c < 10;c++){
                 if(input[r][c] == '+'){
                     game_world[r][c] = 0;
                     copy_of_game_world[r][c] =game_world[r][c];

                 }else{
                     game_world[r][c] = 1;
                     copy_of_game_world[r][c] =game_world[r][c];
                 }
             }
         }

    }


    public void evolution(){
        for(int r = 0;r < 10;r++){
            for(int c = 0;c < 10;c++){
                int one_up_location = this.game_world[r + 1][c];
                int two_up_location = this.game_world[r + 2][c];
                int three_up_location = this.game_world[r + 3][c];
                int one_down_location = this.game_world[r - 1][c];
                int two_down_location = this.game_world[r - 2][c];
                int three_down_location = this.game_world[r - 3][c];
                int one_left_location = this.game_world[r][c - 1];
                int two_left_location = this.game_world[r][c - 2];
                int three_left_location = this.game_world[r][c - 3];
                int one_right_location = this.game_world[r][c + 1];
                int two_right_location = this.game_world[r][c + 2];
                int three_right_location = this.game_world[r][c + 3];
            }
        }
    }


    private boolean Is_alive(int input)
    {
        return input == 1;
    }

}
