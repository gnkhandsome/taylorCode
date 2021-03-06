package test.taylor.com.taylorcode.ui.navigation;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import androidx.navigation.Navigation;
import test.taylor.com.taylorcode.R;
import test.taylor.com.taylorcode.ui.custom_view.selector.Selector;
import test.taylor.com.taylorcode.ui.custom_view.selector.SelectorGroup;

public class NavFragment1 extends StateFragment implements Selector.OnSelectorStateListener {
    private Selector selector;
    private SelectorGroup selectorGroup = new SelectorGroup();
    private static final String KEY_SELECT_STATE = "KEY_SELECT_STATE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_fragment1, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(v -> {
//            Navigation.findNavController(view).navigate(R.id.action_to_f2);
        });
//        selector = view.findViewById(R.id.selector1);
//        selector.setOnSelectorClick(() -> {
//            Navigation.findNavController(view).navigate(R.id.action_to_f2);
//        });
        Selector maleSelector = view.findViewById(R.id.selector_male);
        Selector femaleSelector = view.findViewById(R.id.selector_female);
        maleSelector.setOnSelectorStateListener(this);
        femaleSelector.setOnSelectorStateListener(this);
        maleSelector.setSelectorGroup(selectorGroup);
        femaleSelector.setSelectorGroup(selectorGroup);
    }

    @Override
    protected void onSaveState(Bundle state) {
        if (selector != null) {
            state.putBoolean(KEY_SELECT_STATE, selector.isSelected());
        }
    }

    @Override
    protected void onRestoreState(Bundle state) {
        if (selector != null) {
            boolean isSelect = state.getBoolean(KEY_SELECT_STATE);
            selector.setSelected(isSelect);
        }
    }

    @Override
    public void onStateChange(Selector selector, boolean isSelect) {
    }
}
