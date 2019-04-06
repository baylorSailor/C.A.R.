import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
    public void start() {
        MainMenuView view = new MainMenuView();

        view.btRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
