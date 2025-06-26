package jsnn.jsnn.interfaces;

public interface View {
    /**
     * Initializes the view with the given ViewModel.
     *
     * @param viewModel The ViewModel to be used by the view.
     */
    void initialize(ViewModel viewModel);

    /**
     * Returns the ViewModel associated with this view.
     *
     * @return The ViewModel for this view.
     */
    ViewModel getViewModel();
}
