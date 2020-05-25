#ifndef TODOWINDOW_H
#define TODOWINDOW_H

#include <QWidget>
#include <QTableWidget>

namespace Ui {
class TodoWindow;
}

class TodoWindow : public QWidget
{
    Q_OBJECT

public:
    explicit TodoWindow(QWidget *parent = nullptr);
    ~TodoWindow();

private slots:
    void on_savepushButton_clicked();



    void on_deletepushButton_clicked();

    void on_updatepushButton_clicked();

    void on_tableWidget_clicked(const QModelIndex &index);

private:
    Ui::TodoWindow *ui;
};

#endif // TODOWINDOW_H
