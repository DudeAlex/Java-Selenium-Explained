package model.component;

import model.base.BaseComponent;
import model.base.BasePage;

public class MainHeaderComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    public MainHeaderComponent(Page page){
        super(page);
    }
}
