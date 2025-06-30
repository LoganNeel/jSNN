package jsnn.jsnn.views;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import jsnn.jsnn.viewModels.ScenePaneViewModel;
import javafx.scene.canvas.Canvas;

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
     * The root `Canvas` container for this scene pane's UI components.
     */
    private final Canvas root;

    /**
     * Constructs a new `ScenePaneView` instance with the specified view model.
     *
     * @param viewModel The `ScenePaneViewModel` associated with this view.
     */
    public ScenePaneView(ScenePaneViewModel viewModel) {
        this.viewModel = viewModel;
        // Initialize the root container for this scene pane
        this.root = new Canvas();

         //set the size of the canvas
        this.root.setWidth(800); // Default width
        this.root.setHeight(600); // Default height

        // Draw the initial content of the scene
        draw();

    }

    private void draw() {
        GraphicsContext gc = root.getGraphicsContext2D();
        gc.clearRect(0, 0, root.getWidth(), root.getHeight());

        // Example: Draw a neuron and a connection
        gc.setFill(Color.CORNFLOWERBLUE);
        gc.fillOval(100, 100, 30, 30);

        gc.setStroke(Color.GRAY);
        gc.setLineWidth(2);
        gc.strokeLine(130, 115, 200, 115);
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
        return  root;
    }
}