package jsnn.jsnn.views;

import jsnn.jsnn.viewModels.SelectedItemPaneViewModel;

/**
 * The `SelectedItemPaneView` class represents the view for displaying
 * and interacting with a selected item. It is associated with a
 * `SelectedItemPaneViewModel` to manage its state and behavior.
 */
public class SelectedItemPaneView {

    /**
     * The view model associated with this view, responsible for managing
     * the state and logic of the selected item pane.
     */
    private SelectedItemPaneViewModel selectedItemPaneViewModel;

    /**
     * Default constructor for the `SelectedItemPaneView` class.
     *
     * Creates an instance of the view without initializing the view model.
     */
    public SelectedItemPaneView() {}

    /**
     * Constructs a new `SelectedItemPaneView` instance with the specified view model.
     *
     * @param selectedItemPaneViewModel The `SelectedItemPaneViewModel` to associate with this view.
     */
    public SelectedItemPaneView(SelectedItemPaneViewModel selectedItemPaneViewModel) {
        this.selectedItemPaneViewModel = selectedItemPaneViewModel;
        // Initialize the view components here, if any
    }
}