package jsnn.jsnn.viewModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import jsnn.jsnn.views.ScenePaneView;
import java.io.File;

/**
 * The `PaneHolderViewModel` class manages a collection of `ScenePaneView` instances
 * and tracks the currently selected pane. It provides methods to add, remove, and
 * retrieve panes, as well as manage the selected index.
 */
public class PaneHolderViewModel {
    /**
     * A list of `ScenePaneView` instances representing the panes managed by this view model.
     */
    private final ObservableList<ScenePaneView> paneViewModels = FXCollections.observableArrayList();

    /**
     * An `IntegerProperty` representing the index of the currently selected pane.
     */
    private final IntegerProperty selectedIndex = new SimpleIntegerProperty(0);

    /**
     * Gets the list of `ScenePaneView` instances.
     *
     * @return An observable list of `ScenePaneView` instances.
     */
    public ObservableList<ScenePaneView> getPaneViewModels() {
        return paneViewModels;
    }

    /**
     * Gets the `IntegerProperty` representing the selected index.
     *
     * @return The selected index property.
     */
    public IntegerProperty selectedIndexProperty() {
        return selectedIndex;
    }

    /**
     * Gets the currently selected index.
     *
     * @return The selected index as an integer.
     */
    public int getSelectedIndex() {
        return selectedIndex.get();
    }

    /**
     * Sets the selected index to the specified value if it is within bounds.
     *
     * @param index The index to set as the selected index.
     */
    public void setSelectedIndex(int index) {
        if (index >= 0 && index < paneViewModels.size()) {
            selectedIndex.set(index);
        }
    }

    /**
     * Adds a new `ScenePaneView` to the list of panes.
     * If this is the first pane added, it sets the selected index to 0.
     *
     * @param viewModel The `ScenePaneView` to add.
     */
    public void addPane(ScenePaneView viewModel) {
        paneViewModels.add(viewModel);
        if (paneViewModels.size() == 1) {
            selectedIndex.set(0);
        }
    }

    /**
     * Removes the specified `ScenePaneView` from the list of panes.
     * Updates the selected index accordingly.
     *
     * @param viewModel The `ScenePaneView` to remove.
     */
    public void removePane(ScenePaneView viewModel) {
        int idx = paneViewModels.indexOf(viewModel);
        paneViewModels.remove(viewModel);
        if (paneViewModels.isEmpty()) {
            selectedIndex.set(-1);
        } else if (idx == selectedIndex.get()) {
            selectedIndex.set(Math.max(0, selectedIndex.get() - 1));
        }
    }

    /**
     * Gets the currently active `ScenePaneView` based on the selected index.
     *
     * @return The active `ScenePaneView`, or `null` if no pane is selected.
     */
    public ScenePaneView getActivePaneViewModel() {
        int idx = selectedIndex.get();
        if (idx >= 0 && idx < paneViewModels.size()) {
            return paneViewModels.get(idx);
        }
        return null;
    }
}