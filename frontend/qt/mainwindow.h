#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "todowindow.h"

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

private slots:
    void on_signInPushButton_clicked();

private:
    Ui::MainWindow *ui;
    TodoWindow *todoWindow;
};
#endif // MAINWINDOW_H
