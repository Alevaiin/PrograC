public class ProcessD {
    static String[] childNames = {"ProcessF.java","ProcessG.java"};

    public static void main(String[] args) {
        System.out.println("Proceso D");
        ChildProcess childProcess = new ChildProcess(childNames);
        childProcess.startChilds();
        childProcess.waitForChilds();
    }
}
