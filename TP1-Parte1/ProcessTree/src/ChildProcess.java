import java.io.IOException;

public class ChildProcess {

    public ChildProcess(String[] childNames){
        this.childNames = childNames;
    }
    String[] childNames;
    Process[] childs;

    private ProcessBuilder buildProcess(String name){
        ProcessBuilder pb = new ProcessBuilder("java", name);
        pb.inheritIO();
        pb.redirectErrorStream(true);
        return pb;
    }

    private Process startProcess(ProcessBuilder processBuilder) {
        Process child = null;
        try{
            child = processBuilder.start();
        }catch (IOException ioException){
            System.out.println("Error: " + ioException.getMessage());
        }
        return child;
    }

    public void startChilds(){
        this.childs = new Process[ childNames.length ];
        for (int i = 0; i < childNames.length ; i++) {
            childs[i] = startProcess(buildProcess(childNames[i]));
        }
    }

    public void waitForChilds(){
        if(this.childs == null)
            return;
        try{
            for (Process child : childs) {
                child.waitFor();
            }
        }catch (InterruptedException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
