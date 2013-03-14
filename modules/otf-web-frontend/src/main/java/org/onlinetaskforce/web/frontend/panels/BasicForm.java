package org.onlinetaskforce.web.frontend.panels;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @param <T> type of the model
 * @author jordens
 * @since 10/03/13
 */
public class BasicForm<T> extends Form<T> {

    /**
     * Instantiates the BasicForm
     * @param id Component's id
     */
    public BasicForm(String id) {
        super(id);
    }

    /**
     * Instantiates the BasicForm
     * @param id Component's id
     * @param tiModel Model
     */
    public BasicForm(String id, IModel<T> tiModel) {
        super(id, tiModel);
    }

    /**
     * Convinience method that adds feedback labels for each field of the components
     *
     * @param fc The component
     */
    public void addFormField(FormComponent fc) {
        // Add the component to the components
        this.add(fc);

        // Add feedback label for this editForm
        if(!(fc instanceof RadioGroup || fc instanceof DropDownChoice)) {
            this.add(new ComponentFeedbackPanel(fc.getId() + "-feedback", fc).add(new AttributeModifier("class", Model.of("componentFeedbackPanel"))));
        }
    }

}
