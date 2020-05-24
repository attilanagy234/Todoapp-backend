#ifndef TODOWINDOW_H
#define TODOWINDOW_H

#include <QWidget>

namespace Ui {
class TodoWindow;
}

class TodoWindow : public QWidget
{
    Q_OBJECT

public:
    explicit TodoWindow(QWidget *parent = nullptr);
    ~TodoWindow();

private:
    Ui::TodoWindow *ui;
};

#endif // TODOWINDOW_H
