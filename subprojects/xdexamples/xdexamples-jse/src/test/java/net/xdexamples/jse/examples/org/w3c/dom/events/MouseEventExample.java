package net.xdexamples.jse.examples.org.w3c.dom.events;

import net.xdexamples.support.internal.Scaffolded;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;
import net.xdexamples.support.internal.BaseExample;

@Scaffolded
public class MouseEventExample extends BaseExample<MouseEvent> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(MouseEvent instance) throws Throwable {
        {
            boolean altKey = instance.getAltKey();
        }
        {
            short button = instance.getButton();
        }
        {
            int clientX = instance.getClientX();
        }
        {
            int clientY = instance.getClientY();
        }
        {
            boolean ctrlKey = instance.getCtrlKey();
        }
        {
            boolean metaKey = instance.getMetaKey();
        }
        {
            EventTarget relatedTarget = instance.getRelatedTarget();
        }
        {
            int screenX = instance.getScreenX();
        }
        {
            int screenY = instance.getScreenY();
        }
        {
            boolean shiftKey = instance.getShiftKey();
        }
        {
            String type = any();
            boolean canBubble = any();
            boolean cancelable = any();
            AbstractView view = any();
            int detail = any();
            int screenX = any();
            int screenY = any();
            int clientX = any();
            int clientY = any();
            boolean ctrlKey = any();
            boolean altKey = any();
            boolean shiftKey = any();
            boolean metaKey = any();
            short button = any();
            EventTarget target = any();
            instance.initMouseEvent(type, canBubble, cancelable, view, detail, screenX, screenY, clientX, clientY, ctrlKey, altKey, shiftKey, metaKey, button, target);
        }
    }
}
