public class Conway_game {
    //Attribute
    private int row_max = 10;
    private int col_max = 10;
    private int[][] game_world = new int[row_max][col_max ];
    private char char_world[] = {'+','#'};
    private int[][] copy_of_game_world = new int[row_max][col_max ];


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
         for(int r = 0;r < row_max;r++){
             for(int c = 0;c < col_max;c++){
                 if(input[r][c] == '+'){
                     game_world[r][c] = 0;

                 }else{
                     game_world[r][c] = 1;
                 }
                 copy_of_game_world[r][c] = game_world[r][c];
             }
         }

    }


    public void evolution(){
        for(int r = 0;r < row_max;r++){
            for(int c = 0;c < col_max;c++){
                int Alive = this.game_world[r][c];
                int Dead = this.game_world[r][c];
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

                if(Is_alive(Alive)){

                    if(has_neighbour(one_up_location)){
                        if(has_neighbour(two_up_location)){
                            ///Any live cell with 2 or 3 neighbours becomes remains alive
                            break;
                         }else{
                            this.game_world[r][c] = 0;
                        }

                    }else if(has_neighbour(one_down_location)){
                        if(has_neighbour(two_down_location)){
                            ///Any live cell with 2 or 3 neighbours becomes remains alive
                            break;
                        }else{
                            ///Any live cell with less than 2 neighbours becomes dead
                            this.game_world[r][c] = 0;
                        }

                    }else if(has_neighbour(one_left_location)){
                        if(has_neighbour(two_left_location)){
                            ///Any live cell with 2 or 3 neighbours becomes remains alive
                            break;
                        }else{
                            ///Any live cell with less than 2 neighbours becomes dead
                            this.game_world[r][c] = 0;
                        }

                    }else if(has_neighbour(one_right_location)){
                        if(has_neighbour(two_right_location)){
                            ///Any live cell with 2 or 3 neighbours becomes remains alive
                            break;
                        }else{
                            ///Any live cell with less than 2 neighbours becomes dead
                            this.game_world[r][c] = 0;
                        }

                    }else{
                        ///Any live cell with less than 2 neighbours becomes dead
                        this.game_world[r][c] = 0;
                    }

                }else if(!(Is_alive(Dead))){
                    if(Is_alive(one_up_location)){
                        if(Is_alive(two_up_location)){
                            if(Is_alive(three_up_location)){
                                ///Any dead cell with 3 live cells becomes alive
                                this.game_world[r][c] = 1;
                            }else{
                                break;
                            }

                        }else{
                            break;
                        }

                    }else if(Is_alive(one_down_location)){
                        if(Is_alive(two_down_location)){
                            if(Is_alive(three_down_location)){
                                ///Any dead cell with 3 live cells becomes alive
                                this.game_world[r][c] = 1;
                            }else{
                                break;
                            }

                        }else{
                            break;
                        }

                    }else if(Is_alive(one_left_location)){
                        if(Is_alive(two_left_location)){
                            if(Is_alive(three_left_location)){
                                ///Any dead cell with 3 live cells becomes alive
                                this.game_world[r][c] = 1;
                            }else{
                                break;
                            }
                        }else{
                            break;
                        }

                    }else if(Is_alive(one_right_location)){
                        if(Is_alive(two_right_location)){
                            if(Is_alive(three_right_location)){
                                ///Any dead cell with 3 live cells becomes alive
                                this.game_world[r][c] = 1;
                            }else{
                                break;
                            }
                        }else{
                            break;
                        }

                    }else{
                        break;
                    }
                }



            }
        }
    }

    private void change_other_live_to_dead(){
        for(int r = 0;r < row_max;r++){
            for(int c = 0;c < col_max;c++){
                ///If the new generation is the same as old.It means it was not mutated
                if(this.game_world[r][c] == this.copy_of_game_world[r][c]){
                    ///If it is a live cell,it changes to a dead cell
                    if(Is_alive(this.game_world[r][c])){
                        this.game_world[r][c] = 0;
                    }
                }else{
                    break;
                }
            }
        }
    }

    private boolean Is_alive(int input)
    {
        return input == 1;
    }

    private boolean has_neighbour(int input)
    {
        return ((input == 1) || (input == 0));
    }


  public char[][] display(char[][] input){
        initialise_game(input);
        evolution();
        change_other_live_to_dead();
        char[][] output = new char[row_max][col_max];

        for(int r = 0;r <row_max;r++){
            for(int c = 0;c <col_max;c++){
                if(Is_alive(this.game_world[r][c])){
                    output[r][c] = '#';
                }else{
                    output[r][c] = '+';
                }
            }
        }

       return output;
  }
}
