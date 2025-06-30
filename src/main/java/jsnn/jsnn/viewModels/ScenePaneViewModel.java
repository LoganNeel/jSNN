package jsnn.jsnn.viewModels;

import java.io.File;

/**
 * The `ScenePaneViewModel` class represents a view model for a scene pane.
 * It is responsible for managing the file name associated with the scene pane.
 */
public class ScenePaneViewModel {

    /**
     * The name of the file associated with this scene pane.
     */
    private String fileName;

    /**
     * Default constructor for the `ScenePaneViewModel` class.
     *
     * Initializes the `fileName` property with a unique name. If a file named
     * "defaultFile.jsnn" already exists, it appends an index (e.g., "defaultFile_1.jsnn")
     * until a unique name is found.
     */
    public ScenePaneViewModel() {
        String baseName = "defaultFile";
        String extension = ".jsnn";
        String candidateName = baseName + extension;
        int index = 1;
        File file = new File(candidateName);
        while (file.exists()) {
            candidateName = baseName + "_" + index + extension;
            file = new File(candidateName);
            index++;
        }
        this.fileName = candidateName;
    }

    /**
     * Retrieves the base name of the file (without the extension).
     *
     * @return The base name of the file as a `String`.
     */
    public String getName() {
        return fileName.split("\\.")[0];
    }
}