package jsnn.jsnn.models;

import jsnn.jsnn.interfaces.View;
import jsnn.jsnn.interfaces.ViewModel;

public abstract class BaseView implements View {

    public ViewModel viewModel;

    @Override
    public abstract void initialize(ViewModel viewModel);

    @Override
    public abstract ViewModel getViewModel();
}