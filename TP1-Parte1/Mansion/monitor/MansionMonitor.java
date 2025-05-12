package monitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MansionMonitor {

    private static final String[] rooms = {"AtticCamera","BasementCamera","BedroomCamera","GardenCamera","KitchenCamera","MausoleumCamera"};

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Iniciando MansionMonitor");
        if(args.length != 2) {
            System.out.println("Error en parametros");
            return;
        }
        try{
            Integer.parseInt(args[0],10);
        }catch (NumberFormatException error){
            System.out.println("Duracion invalida");
            return;
        }

        try{
            Integer.parseInt(args[1],10);
        }catch (NumberFormatException error){
            System.out.println("Frecuencia invalida");
            return;
        }
        List<Process> processes = new ArrayList<>();

        //Iniciamos un proceso por cada habitacion
        for (String room : rooms){
            processes.add(startRoomProcess(room,args[0], args[1]));
        }

        //Esperamos que todos los procesos terminen
        for (Process process : processes){
            process.waitFor();
        }

    }

    public static Process startRoomProcess(String room,String duration,String frequency) throws IOException {
        String classpath = System.getProperty("java.class.path");
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "monitor.cameras.rooms."+room,duration, frequency);
        pb.redirectErrorStream(true);
        pb.inheritIO();
        return pb.start();
    }
}
