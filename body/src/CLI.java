import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by biospore on 9/17/15.
 */
public class CLI implements Runnable {
    private IEngine engine;
    private Scanner scanner;

    public CLI(){
        engine = new Engine();
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        String[] cmd = scanner.nextLine().split(" ");
        if (cmd[0].equals("?")){
            System.out.println("Help:");
            System.out.println("\tadd_profile <login> <password>\tSet up new profile.");
            System.out.println("\tget_profile_info <login>\tShow profile info by login.");
            System.out.println("\tdel_profile <login>\tRemove profile with 'login'.");
            System.out.println("\tget_all_profiles\tShow all profiles.");
            System.out.println("\tget_active_profile\tShow active profile info.");
            System.out.println("\tset_active_profile <login>\tChange active profile to <login>.");
            System.out.println("\tget_list\tShow all <type> list.");
        }
        else if (cmd[0].equals("add_profile")){
            engine.addProfile(cmd[1], cmd[2]);
        }
        else if (cmd[0].equals("get_profile_info")){
            IProfile profile = engine.getProfile(cmd[1]);
            if (profile != null) {
                System.out.println();
                System.out.println("Profile:\t".concat(profile.getLogin()));
                System.out.println("Password:\t".concat(profile.getPassword()));
            }
            else{
                System.out.println("An error occurred!");
            }
        }
        else if(cmd[0].equals("get_all_profiles")){
            Set<IProfile> profiles = engine.getProfilesList();
            for (IProfile profile : profiles){
                System.out.println();
                System.out.println("Profiles:");
                System.out.println("\tProfile:\t".concat(profile.getLogin()));
            }
        }
        else if(cmd[0].equals("del_profile")){
            if (engine.deleteProfile(cmd[1])){
                System.out.println("Profile deleted!");
            }
            else{
                System.out.println("An error occurred!");
            }
        }
        else if(cmd[0].equals("get_active_profile")){
            IProfile profile = engine.getActiveProfile();
            if (profile != null){
                System.out.println();
                System.out.println("Profile:\t".concat(profile.getLogin()));
                System.out.println("Password:\t".concat(profile.getPassword()));
            }
            else{
                System.out.println("An error occurred!");
            }
        }
        else if(cmd[0].equals("set_active_profile")){
                if (engine.setActiveProfile(cmd[1])){
                    System.out.println("Active profile changed!");
                }
            else{
                    System.out.println("An error occurred!");
                }
        }
        else if(cmd[0].equals("get_list")){
            Collection<IEntry> list =  engine.getList();
            if (list != null){
                for (IEntry entry: list){
                    System.out.println("Entry:");
                    System.out.println("\tId:\t" + entry.getId());
                    System.out.println("\tTitle:\t" + entry.getTitle());
                }
            }
            else{
                System.out.println("List is empty!");
            }
        }

    }
}
/**
 * Изменить тип хранения данных на список;
 */

/**
 * add_profile login password => void
 * get_profile_info login => IProfile || null
 * get_all_profiles => Set<IProfile>
 * del_profile login  => true || false
 * get_active_profile login => IProfile || null
 * set_active_profile login => true || false
 * get_list => TreeMap<Long, IEntry>
 *
 */