package code;

import java.util.HashMap;

public class Explorer {
    
private HashMap<String,Integer> explorers;
private int temp;

public Integer RemovingExplorer(String Player){
        
        if(explorers.containsKey(Player)){
                temp=explorers.get(Player);
                if(temp>0){
                    return explorers.put(Player,temp-1);
                }
            }
        return explorers.put(Player, 0);
        
    } 
    public Integer AddingExplorers(String Player){
        if(explorers.containsKey(Player)){
            temp=explorers.get(Player);
            return explorers.put(Player , temp+1);
            }
        return explorers.put(Player, 0);
        }
    
    
    public boolean MovementExplorers(){
        //state is picked from jbutton
    int state =0;
    switch(state){
    
    case 0:
        //pass in value for x,y
        if(t.get[x][y].contains(tile)&&t.get[x][y+1].contains(tile)){
        if(getPathX6ToX3()!=0){ //check if path is avaiable
            t.get[x][y].RemoveExplorers(Player); //get the position of the tile chosen
            t.get[x][y+1].AddExplorers(Player); //get the position tile moving too
            return true;
            break;
        }
        return false;
        break;
        }
        
        
    case 1:
        if(t.get[x][y].contains(tile)&&t.get[x][y-1].contains(tile)){
        if(getPathX3ToX6()!=0){ //check if path is avaiable
            t.get[x][y].RemoveExplorers(Player); //get the position of the tile chosen
            t.get[x][y-1].AddExplorers(Player); //get the position tile moving too
            return true;
            break;
        }
        else{
            return false;
            break;
            
        }
        }
    case 2:
        if(t.get[x][y].contains(tile)&&t.get[x+1][y+1].contains(tile)){
        if(getPathX5ToX2()!=0){ //check if path is avaiable
            t.get[x][y].RemoveExplorers(Player); //get the position of the tile chosen
            t.get[x+1][y+1].AddExplorers(Player); //get the position tile moving too
            return true;
            break;
        }
        else{
            return false;
            break;
        }
        }
    case 3:
        if(t.get[x][y].contains(tile)&&t.get[x-1][y-1].contains(tile)){
        if(getPathX2ToX5()!=0){ //check if path is avaiable
            t.get[x][y].RemoveExplorers(Player); //get the position of the tile chosen
            t.get[x-1][y-1].AddExplorers(Player); //get the position tile moving too
            return true;
            break;
        }
        else{
            return false;
            break;
        }
        }
    case 4:
        if(t.get[x][y].contains(tile)&&t.get[x+1][y-1].contains(tile)){
        if(getPathX4ToX1()!=0){ //check if path is avaiable
            t.get[x][y].RemoveExplorers(Player); //get the position of the tile chosen
            t.get[x+1][y-1].AddExplorers(Player); //get the position tile moving too
            return true;
            break;
        }
        else{
            return false;
            break;
        }
        }
    case 5:
        if(t.get[x][y].contains(tile)&&t.get[x-1][y+1].contains(tile)){
        if(getPathX1ToX4()!=0){ //check if path is avaiable
            t.get[x][y].RemoveExplorers(Player); //get the position of the tile chosen
            t.get[x-1][y+1].AddExplorers(Player); //get the position tile moving too
            return true;
            break;
        }
        else{
            return false;
            break;
        }
    
    }
        
        
    }
        }

}
