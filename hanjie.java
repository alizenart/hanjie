import java.util.*;

public class hanjie
{
  public static void main(String[]args)
  {
    System.out.println("oh");
    hanjieObj[] top = new hanjieObj[10];
    hanjieObj[] side = new hanjieObj[10];
    
    top[0] = new hanjieObj(0, 3, 1);
    top[1] = new hanjieObj(0, 0, 2);
    top[2] = new hanjieObj(0, 0, 3);
    top[3] = new hanjieObj(0, 2, 4);
    top[4] = new hanjieObj(0, 5, 4);
    top[5] = new hanjieObj(0, 5, 4);
    top[6] = new hanjieObj(0, 2, 4);
    top[7] = new hanjieObj(0, 0, 3);
    top[8] = new hanjieObj(0, 0, 2);
    top[9] = new hanjieObj(3, 1, 1);
    
    side[0] = new hanjieObj(1, 4, 1);
    side[1] = new hanjieObj(1, 4, 1);
    side[2] = new hanjieObj(1, 2, 1);
    side[3] = new hanjieObj(0, 0, 2);
    side[4] = new hanjieObj(0, 0, 2);
    side[5] = new hanjieObj(0, 0, 0);
    side[6] = new hanjieObj(0, 0, 4);
    side[7] = new hanjieObj(0, 6, 1);
    side[8] = new hanjieObj(0, 0, 8);
    side[9] = new hanjieObj(0, 0, 10);
    
    
    String[][] grid = new String[10][10];
    
    for(int i = 0; i < 10; i++)
    {
      for(int j = 0; j < 10; j++)
      {
        grid[i][j] = ".";
      }
    }
    
    
    //grid[row][column] -- top is checking column, side is checking row
    //grid[0-10][0] ==> top[0]
    //grid[side][column]
    
    
    
    int progress = 1;
    
    //first: start with inital conditions
    
    //              counter
    for(int i = 0; i < 10; i++)
    {
      hanjieShift(top, side, i, grid, 0, 1, 1);
    }
    
    
    
    for(int count = 0; count< 10; count++)
    {
      for( int a = 0; a < 10; a++)
      {
        for(int b = 0; b<10; b++)
        {
          for(int c = 0; c<10; c++)
          {
            if( (a + b + c) < 10 - (side[count].getNum1() + side[count].getNum2() + side[count].getNum3()))
            {
              hanjieShift(top, side, count, grid, a, b, c); 
            }
          }
        }
      }
   
    }
  

    
    
    
    /*
    int a = 1;
    if( a == 1 )//hanjieCheck is true
    {
      //print grid
    }
    
    else//redo hanjieShift -- switching around a,b,and c but ALSO counter --> testing out different rows
      //intial conditions: a = 0, b = 1, c = 1 (if b and c exist)
      //can increase a, b, and c
    {
      //reset grid
      for(int i = 0; i < 10; i++)
      {
        for(int j = 0; j < 10; j++)
        {
          grid[i][j] = ".";
        }
      }
      
      
      //a + side[3].getNum1() + b + side[3].getNum2() + c + side[3].getNum3() < 10
      //(a + b + c) < 10 - (side[3].getNum1() + side[3].getNum2() + side[3].getNum3())
      
      
      if( (a1 + b1 + c1) < 10 - (side[3].getNum1() + side[3].getNum2() + side[3].getNum3()))
      {
        //run hanjieShift with different a, b, or/and c in same row. ==> do this for ALL the different rows
      
        //hanjieShift( a + 1, b, c)
        //hanjieShift( a, b + 1, c)
        //hanjieShift( a, b, c + 1)
      
        
      }*/
      
      
      
    }

  
  
  
  
  //side == turn all 3's into counter
  
  // change a, b, or/and c in each interation
  // void ==> grid[][]
  public static boolean hanjieShift(hanjieObj[] top, hanjieObj[] side, int counter, String[][] grid, int a, int b, int c) 
    {
      for(int i = 0; i < 10; i++)
        {
         grid[counter][i] = ".";
        }

      int z = 0;
      if( side[counter].getNum1() == 0)
      {
        z++;
      }
      
      if( side[counter].getNum2() == 0)
      {
        z++;
      }
      
      if( side[counter].getNum3() == 0)
      {
        z++;
      }
      
      
      
      if(z == 0)//3inputs
      {
        //variables: a - space before num1
        //           b - space between num1 and num2
        //           c - space between num2 and num3
        
        
        
        // first number = how many numbers
        
        //the "int i = 0" will shift, and as it increase
        //int i = a; i< side[3].getNum1() + a (a increases per iteration)
        
        for(int i = a; i< side[counter].getNum1() + a; i++)
        {
          grid[counter][i] = "X";
          
        }
        
        //second number = number AFTER more one or more spaces (b)
        //start at a + side[3].getNum1()  + b
        //end at a + side[3].getNum1() + b + side[3].getNum2()
        
        //b >= 1, b is the number of spaces between Num1 and num2 in answer key (b increases per iteration)
        
        
        for(int i = a + side[counter].getNum1() + b; i < a + side[counter].getNum1() + b + side[counter].getNum2(); i++)
        {
          grid[counter][i] = "X";
        }
        
        
        //third number= number AFTER more one or more spaces (c)
        
        //start at a + side[3].getNum1() + b + side[3].getNum2() + c
        //end at a + side[3].getNum1() + b + side[3].getNum2() + c + side[3].getNum3()
        //c>=1 
        
        
        //MUST be less than 10 
        for(int i = a + side[counter].getNum1() + b + side[counter].getNum2() + c; i < a + side[counter].getNum1() + b + side[counter].getNum2() + c + side[counter].getNum3(); i++)
        {
          grid[counter][i] = "X";
        }

      }
      
      
      
      
      
      if(z == 1)//2inputs
      {
        
        //same as when z == 0, except with only a and b for num2 and num3
        

        for(int i = a; i< side[counter].getNum2() + a; i++)
        {
          grid[counter][i] = "X";
          
        }
        
        //second number = number AFTER more one or more spaces (b)
        //start at a + side[3].getNum1()  + b
        //end at a + side[3].getNum1() + b + side[3].getNum2()
        
        //b >= 1, b is the number of spaces between Num1 and num2 in answer key (b increases per iteration)

        for(int i = a + side[counter].getNum2() + b; i < a + side[counter].getNum2() + b + side[counter].getNum3(); i++)
        {
          grid[counter][i] = "X";
        }
        
      }
      
      if(z == 2)//1inputs
      {
        //same as z == 1 but only with a

        

        for(int i = a; i< side[counter].getNum2() + a; i++)
        {
          grid[counter][i] = "X";
          
        }
       
      }
      
      
      if(z == 3)//0inputs
      {
        //no "X"'s 
        
        for(int i = 0; i<10; i++)
        {
          grid[counter][i] = ".";
        }
        
      }
      
      int check = 0;
      for( int i = 0; i <10 ; i++)
      {
        if( hanjieCheck( top, grid, i))
        {
          check++;
        }
      }
      
      if( check == 10)
      {
        printGrid(grid);
        return true;
      }
      
      else
      {
        return false;
      }





    }
    
  
    public static boolean hanjieCheck(hanjieObj[] top, String[][] grid, int col) //run with col = 0 initially
    {
      //testing: checking JUST for column 3
      
      //recursion: move down each column checking if EVERY one is true 

      int a = top[col].getNum1();
      int b = top[col].getNum2();
      int c = top[col].getNum3();
      
      int column = col; //go from 1-10 ==> check each column
      
      int progress = 1;

      int counter = 0;
      
      
      int z = 0;
      if( top[col].getNum1() == 0)
      {
        z++;
      }
      
      if( top[col].getNum2() == 0)
      {
        z++;
      }
      
      if( top[col].getNum3() == 0)
      {
        z++;
      }
      
      //if z = 0
      
      if( z == 0 )
      {
        for( int i = 0; i<10; i++) //check for one row
        {
          if(grid[i][column] == "X")
          {
            while (progress == 1)
            {
              if(grid[i][column] == "X")
              {
                counter++;
                i++;
              }
              else
              {
                progress = 2;
              }
            }
            
            if (counter == a)
            {
              progress = 1; 
              counter = 0;
              
              while (progress == 1)
              {
                if(grid[i][column] == "X")
                {
                  counter++;
                  i++;
                }
                else
                {
                  progress = 2;
                }
              }
              
              if(counter == b)
              {
                progress = 1; 
                counter = 0;
                
                while (progress == 1)
                {
                  if(grid[i][column] == "X")
                  {
                    counter++;
                    i++;
                  }
                  else
                  {
                    progress = 2;
                  }
                }
                
                if(counter == c)
                {
                  return true;
                  
                }
                
              }
            }
          }
        }
      }
      
      
      if( z == 1 )
      {
        for( int i = 0; i<10; i++) //check for all rows
        {
          if(grid[i][column] == "X")
          {
            while (progress == 1)
            {
              if(grid[i][column] == "X")
              {
                counter++;
                i++;
              }
              else
              {
                progress = 2;
              }
            }
            
            if (counter == b)
            {
              progress = 1; 
              counter = 0;
              
              while (progress == 1)
              {
                if(grid[i][column] == "X")
                {
                  counter++;
                  i++;
                }
                else
                {
                  progress = 2;
                }
              }
            
              if(counter == c)
              {
                return true;
              }
            }
          }
        }
      }
      
      
      if( z == 2)
      {
        for( int i = 0; i<10; i++) //check for all rows
        {
          if(grid[i][column] == "X")
          {
            while (progress == 1)
            {
              if(grid[i][column] == "X")
              {
                counter++;
                i++;
              }
              else
              {
                progress = 2;
              }
            }
            
            if (counter == c)
            {
              return true;
            }
          }
        }
      }
      
      if( z == 3)
      {
        for( int i = 0; i<10; i++)
        {
          if(grid[i][column] == "X")
          {
            while (progress == 1)
            {
              if(grid[i][column] == "X")
              {
                counter++;
                i++;
              }
              else
              {
                progress = 2;
              }
            }
            
            if (counter == c)
            {
              return true;
            }
          }
        }
        
      }
      
      
      
      return false;
    }
      
    
    public static void printGrid(String[][] grid)
    {
      for(int i = 0; i<10; i++)//row
      {
        for(int j = 0; j<10; j++)//column
        {
          System.out.print( grid[i][j] );
        }
        System.out.println();
      }
      
      
      
    }
                                               
      
      
      
      
    
      
      //check each row 
      
      //for(int i = 0; i<10; i++)
      //for z = 0, in order to check, there MUST be Num1 consecutive "X"'s / x>=1 spaces/  Num2 consecutive "X"'s /  x>=1 spaces / Num3 consecutive "X"'s
      
      



      //grid[0-10][0] ==> top[0]

         
      
      
      
      
      
      
    
  


}