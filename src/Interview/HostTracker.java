package Interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HostTracker {

    class Tracker{
        HashMap<String, List<Boolean>> hostMap = new HashMap<>();

        public String allocate(String hostType){
            if(hostMap.get(hostType) == null){
                hostMap.put(hostType,
                            new ArrayList<Boolean>(){{add(true);}});
                return hostType+'1';
            } else{
                List<Boolean> availableSlots = hostMap.get(hostType);
                int index = -1;
                for(int i =0; i< availableSlots.size();i++){
                    if(!availableSlots.get(i)){
                        index=i;
                        break;
                    }
                }
                if(index == -1){
                    availableSlots.add(true);
                    return hostType+availableSlots.size();
                } else{
                    availableSlots.add(index, true);
                    return hostType+(index+1);
                }
            }
        }
        void deallocate(String hostName){
            String[] hostdetails = hostName.split("(?<=\\D)(?=\\d)");
            String hostType = hostdetails[0];
            int hostIndex = Integer.parseInt(hostdetails[1]);
            if(hostMap.get(hostType) != null){
                List<Boolean> availableSlots = hostMap.get(hostType);
                if(hostIndex -1 < availableSlots.size()){
                    availableSlots.add(hostIndex -1, false);
                }
            }
        }
    }

    List<String> hostAllocation(String[] queries) {
        Tracker tracker = new Tracker();
        List<String> ans = new ArrayList<>();
        for (String query : queries) {
            String[] task = query.split(" ");
            if (task[0].equals("A")) {
                ans.add(tracker.allocate(task[1]));
            }
            if (task[0].equals("D")) {
                tracker.deallocate(task[1]);
            }
        }
        return ans;
    }

}

class Execute {

    public static void main(String[] args) {
        HostTracker tracker = new HostTracker();
        System.out.println(tracker.hostAllocation(new String[]{
            "A fbc",
            "D fbc1",
            "A fbc"
        }));
    }
}
