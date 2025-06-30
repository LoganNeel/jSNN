package jsnn.jsnn.views;

import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import jsnn.jsnn.viewModels.ScenePaneViewModel;

/**
 * The `ScenePaneView` class represents the view for a single scene pane.
 * It is responsible for displaying the content of the scene and interacting
 * with its associated `ScenePaneViewModel`.
 */
public class ScenePaneView {
    /**
     * The view model associated with this scene pane.
     */
    private final ScenePaneViewModel viewModel;

    /**
     * The root `VBox` container for this scene pane's UI components.
     */
    private final VBox root;

    /**
     * Constructs a new `ScenePaneView` instance with the specified view model.
     *
     * @param viewModel The `ScenePaneViewModel` associated with this view.
     */
    public ScenePaneView(ScenePaneViewModel viewModel) {
        this.viewModel = viewModel;
        this.root = new VBox();
        // VBox.setVgrow(root, Priority.ALWAYS); // Uncomment if vertical growth is needed
        root.getChildren().add(new Label("Hello from ScenePaneView!"));
    }

    /**
     * Retrieves the title of the scene pane, which is derived from the view model's name.
     *
     * @return The title of the scene pane as a `String`.
     */
    public String getTitle() {
        return viewModel.getName();
    }

    /**
     * Retrieves the root `Node` of this scene pane, which can be used
     * to display the pane in the UI.
     *
     * @return The root `Node` of this scene pane.
     */
    public Node getRoot() {
        return root;
    }
}