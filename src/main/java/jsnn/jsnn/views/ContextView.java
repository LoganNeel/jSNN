package jsnn.jsnn.views;

import jsnn.jsnn.interfaces.ViewModel;
import jsnn.jsnn.models.BaseView;

/**
 * The `ContextView` class extends the `BaseView` class and represents
 * a specific view in the application. It is responsible for managing
 * the initialization and retrieval of its associated `ViewModel`.
 */
public class ContextView extends BaseView {

    /**
     * Constructs a new `ContextView` instance with the specified `ViewModel`.
     *
     * @param viewModel The `ViewModel` to associate with this view.
     */
    public ContextView(ViewModel viewModel) {
        initialize(viewModel);
    }

    /**
     * Initializes the `ContextView` with the provided `ViewModel`.
     *
     * @param viewModel The `ViewModel` to initialize this view with.
     */
    @Override
    public void initialize(ViewModel viewModel) {
        // Initialization logic for the ContextView
        this.viewModel = viewModel;
    }

    /**
     * Retrieves the `ViewModel` associated with this view.
     *
     * @return The `ViewModel` instance associated with this view.
     */
    @Override
    public ViewModel getViewModel() {
        // Return the ViewModel associated with this view
        return this.viewModel;
    }

}