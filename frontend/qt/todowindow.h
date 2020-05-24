#ifndef TODOWINDOW_H
#define TODOWINDOW_H

#include <QDialog>
#include <QMainWindow>
#include <QListView>
#include <QStringListModel>

namespace Ui {
class TodoWindow;
}

class TodoWindow : public QMainWindow

{
    Q_OBJECT

public:
    TodoWindow();

protected slots:
    void onAdd();
    void onRemove();

private:
    Ui::TodoWindow *ui;
    QListView* m_pwPending = nullptr;
    QListView* m_pwCompleted = nullptr;

    QAction* m_pActAdd = nullptr;
    QAction* m_pActRemove = nullptr;
};

#endif // TODOWINDOW_H
