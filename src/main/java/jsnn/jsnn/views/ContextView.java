package jsnn.jsnn.views;

import jsnn.jsnn.interfaces.ViewModel;
import jsnn.jsnn.models.BaseView;


public class ContextView extends BaseView {

    public ContextView(ViewModel viewModel) {
        initialize(viewModel);
     }

    @Override
    public void initialize(ViewModel viewModel) {
        // Initialization logic for the ContextView
        this.viewModel = viewModel;
    }

    @Override
    public ViewModel getViewModel(){
        // Return the ViewModel associated with this view
        return this.viewModel;
    }

}
