import java.io.File;

public class DeleteFolder {

    public static void main(String[] args) {
        String folderToCheck = "/Users/faisalsmac/Desktop/k_CBIS-DDSM/jpg_img";
        deleteFolderIfNotFull(new File(folderToCheck));
    }

    public static void deleteFolderIfNotFull(File parentFolder) {
        if (!parentFolder.exists() || !parentFolder.isDirectory()) {
            System.out.println("Error: '" + parentFolder + "' is not a valid directory.");
            return;
        }

        File[] folders = parentFolder.listFiles();
        if (folders != null) {
            for (File folder : folders) {
                if (folder.isDirectory()) {
                    File[] files = folder.listFiles();
                    if (files != null && files.length > 0) {
                        String firstFileName = files[0].getName();
                        if (!firstFileName.startsWith("full")) {
                            System.out.println("Deleting folder: " + folder.getName());
                            // Use deleteFolderRecursive(folder) to delete the folder and its contents recursively
                            // Be careful when using this, as it deletes everything inside the folder.
                            // Uncomment the line below after verifying you want to delete.
                            // deleteFolderRecursive(folder);
                        }
                    }
                }
            }
        }
    }

    public static void deleteFolderRecursive(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteFolderRecursive(file);
                }
            }
        }
        folder.delete();
    }
}
