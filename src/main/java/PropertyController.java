import Fields.*;
//[group][0wnedby][house/hotel]
public class PropertyController {
    private int[][][] properties = new int[8][][];

    public PropertyController(Field[] fields){
        //Loops through each group in properties
        for (int i = 0; i < properties.length; i++) {
            int temp = 0;
            //for each group in propeties loops through fields to find coresponding fields
            for (int j = 0; j < fields.length; j++) {
                if(fields[j] instanceof Properties){

                }
            }
        }
    }
}

