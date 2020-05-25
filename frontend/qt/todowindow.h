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

    void on_signOutpushButton_clicked();

    void on_projectSavepushButton_clicked();

    void on_projectUpdatepushButton_clicked();

    void on_projectDeletepushButton_clicked();

    void on_labelSavepushButton_clicked();

    void on_labelUpdatepushButton_clicked();

    void on_labelDeletepushButton_clicked();

    void on_taskSavepushButton_clicked();

    void on_taskUpdatepushButton_clicked();

    void on_taskDeletepushButton_clicked();

    void on_tableWidget_2_clicked(const QModelIndex &index);

    void on_tableWidget_3_clicked(const QModelIndex &index);

private:
    Ui::TodoWindow *ui;

};

#endif // TODOWINDOW_H
