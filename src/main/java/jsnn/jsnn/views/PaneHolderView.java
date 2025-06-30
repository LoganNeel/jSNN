package jsnn.jsnn.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import jsnn.jsnn.viewModels.PaneHolderViewModel;
import jsnn.jsnn.viewModels.ScenePaneViewModel;

/**
 * The `PaneHolderView` class represents the view for managing a collection of tabs.
 * It interacts with the `PaneHolderViewModel` to synchronize the state of the tabs
 * and provides functionality for adding and removing panes.
 */
public class PaneHolderView {
    /**
     * The `TabPane` component that displays the tabs.
     */
    @FXML public TabPane tabPane;

    /**
     * The `VBox` component that contains the "Add Pane" button and related UI.
     */
    @FXML public VBox AddPaneStack;

    /**
     * The view model associated with this view, responsible for managing the state of the panes.
     */
    private final PaneHolderViewModel viewModel = new PaneHolderViewModel();

    /**
     * Default constructor for the `PaneHolderView` class.
     *
     * Initializes the view without accessing FXML fields.
     */
    public PaneHolderView() {
        // No FXML field access here!
    }

    /**
     * Initializes the `PaneHolderView` by setting up listeners and binding the view
     * to the view model. This method is called automatically by the JavaFX framework.
     */
    @FXML
    public void initialize() {
        // Listen for changes in the list of pane view models and update the tabs accordingly.
        viewModel.getPaneViewModels().addListener((javafx.collections.ListChangeListener<ScenePaneView>) change -> {
            tabPane.getTabs().clear();
            for (ScenePaneView vm : viewModel.getPaneViewModels()) {
                Tab tab = new Tab(vm.getTitle());
                tab.setUserData(vm);
                tab.setContent(vm.getRoot()); // Show the view in the tab
                tab.setOnClosed(e -> viewModel.removePane(vm));
                tabPane.getTabs().add(tab);
            }
            AddPaneStack.setVisible(viewModel.getPaneViewModels().isEmpty());
        });
        AddPaneStack.setVisible(viewModel.getPaneViewModels().isEmpty());

        // Update the selected index in the view model when the selected tab changes.
        tabPane.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            viewModel.setSelectedIndex(newVal.intValue());
        });

        // Listen for changes in the tabs and update the "Add Pane" button visibility.
        tabPane.getTabs().addListener((javafx.collections.ListChangeListener<Tab>) change -> {
            if (tabPane.getTabs().isEmpty()) {
                AddPaneStack.setVisible(true);
                viewModel.selectedIndexProperty().set(-1);
            } else {
                AddPaneStack.setVisible(false);
            }
        });

        // Update the selected tab in the `TabPane` when the selected index in the view model changes.
        viewModel.selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            tabPane.getSelectionModel().select(newVal.intValue());
        });
    }

    /**
     * Handles the "Add Pane" button click event.
     *
     * Creates a new `ScenePaneView` with a corresponding `ScenePaneViewModel`
     * and adds it to the view model.
     */
    @FXML
    public void onAddPaneClicked() {
        viewModel.addPane(new ScenePaneView(new ScenePaneViewModel()));
    }
}