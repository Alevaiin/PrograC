public class ProcessB {
    static String[] childNames = {"ProcessC.java","ProcessD.java"};

    public static void main(String[] args) {
        System.out.println("Proceso B");
        ChildProcess childProcess = new ChildProcess(childNames);
        childProcess.startChilds();
        childProcess.waitForChilds();
    }
}
