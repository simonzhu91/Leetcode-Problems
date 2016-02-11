public class SimplifyPath {
    public String simplifyPath(String path) {
        ArrayList<String> path_arr = new ArrayList<String>();
        
        String[] arr = path.substring(1).split("/");
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("..")){
                // if nothing in path, pushes ".."
                if(path_arr.size() == 0){
                    // do nothing if no content
                }
                else{
                    // looks at the last added value
                    String last = path_arr.get(path_arr.size() - 1);
                    path_arr.remove(path_arr.size() - 1);
                    
                }
            }else if(arr[i].equals(".")){
                // ignores a single .
            }else if(arr[i].equals("")){
                // ignores a nothing
            }else{
                path_arr.add(arr[i]);
            }
        }
        
        String toRet = "/";
        for(int i = 0 ; i < path_arr.size() ; i++){
            toRet += path_arr.get(i);
            
            if(i != path_arr.size() - 1)
                toRet += "/";
        }
        
        return toRet;
    }
}