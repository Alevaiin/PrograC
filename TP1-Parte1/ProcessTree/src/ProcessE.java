public class ProcessE {
    static String[] childNames = {"ProcessH.java","ProcessI.java"};

    public static void main(String[] args) {
        System.out.println("Proceso E");
        ChildProcess childProcess = new ChildProcess(childNames);
        childProcess.startChilds();
        childProcess.waitForChilds();
    }
}
