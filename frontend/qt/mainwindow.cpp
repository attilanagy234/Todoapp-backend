#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QMessageBox>
#include "todowindow.h"
#include <QJsonDocument>
#include <QJsonValue>
#include <QJsonArray>
#include <QJsonObject>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    connect(&manager,&QNetworkAccessManager::authenticationRequired,this,&MainWindow::authenticationRequired);
    connect(&manager,&QNetworkAccessManager::encrypted,this,&MainWindow::encrypted);
    connect(&manager,&QNetworkAccessManager::networkAccessibleChanged,this,&MainWindow::networkAccessibleChanged);
    connect(&manager,&QNetworkAccessManager::preSharedKeyAuthenticationRequired,this,&MainWindow::preSharedKeyAuthenticationRequired);
    connect(&manager,&QNetworkAccessManager::proxyAuthenticationRequired,this,&MainWindow::proxyAuthenticationRequired);
    connect(&manager,&QNetworkAccessManager::sslErrors,this,&MainWindow::sslErrors);

}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::get(QString location)
{
    qInfo() << "Getting from server...";
    QNetworkReply* reply = manager.get(QNetworkRequest(QUrl(location)));
    connect(reply,&QNetworkReply::readyRead,this,&MainWindow::readyRead);
}

void MainWindow::post(QString location, QByteArray data)
{
    qInfo() << "Posting to server...";
    QNetworkRequest request = QNetworkRequest(QUrl(location));
    request.setHeader(QNetworkRequest::ContentTypeHeader,"application/json");
//    request.setHeader(QNetworkRequest::ContentTypeHeader,QStringLiteral("Content-Type: application/json; charset=utf-8"));
//    request.setHeader(QNetworkRequest::ContentTypeHeader,"application/raw");


    QNetworkReply* reply = manager.post(request, data);
    connect(reply,&QNetworkReply::readyRead,this,&MainWindow::readyRead);
}



void MainWindow::on_signInPushButton_clicked()
{
    todoWindow = new TodoWindow();
    todoWindow->setWindowTitle("Todoz");
    todoWindow->setFixedSize(1200,600);
    this->get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
//    this->hide();
    todoWindow->show();
}

void MainWindow::readyRead()
{
    qInfo() << "ReadyRead";

    QNetworkReply* reply = qobject_cast<QNetworkReply*>(sender());
    if(reply) qInfo() << reply->readAll();
}

void MainWindow::authenticationRequired(QNetworkReply *reply, QAuthenticator *authenticator)
{
    qInfo() << "authenticationRequired";

}

void MainWindow::encrypted(QNetworkReply *reply)
{
    qInfo() << "encrypted";

}

void MainWindow::finished(QNetworkReply *reply)
{
    qInfo() << "finished";

}

void MainWindow::networkAccessibleChanged(QNetworkAccessManager::NetworkAccessibility accessible)
{
    qInfo() << "networkAccessibleChanged";

}

void MainWindow::preSharedKeyAuthenticationRequired(QNetworkReply *reply, QSslPreSharedKeyAuthenticator *authenticator)
{
    qInfo() << "preSharedKeyAuthenticationRequired";

}

void MainWindow::proxyAuthenticationRequired(const QNetworkProxy &proxy, QAuthenticator *authenticator)
{
    qInfo() << "proxyAuthenticationRequired";

}

void MainWindow::sslErrors(QNetworkReply *reply, const QList<QSslError> &errors)
{
    qInfo() << "sslErrors";

}

void MainWindow::on_registerPushButton_clicked()
{
    QString location = "localhost:8080/register";
    QJsonObject obj;
    QString emailString = ui->registerEmailLineEdit->text();
    QString nameString = ui->registerNameLineEdit->text();
    QString passwordString = ui->registerPasswordLineEdit->text();
    obj["name"] = nameString;
    obj["email"] = emailString;
    obj["password"] = passwordString;
    QJsonDocument doc(obj);
    QByteArray data = doc.toJson();
    this->post(location, data);
//    QJsonObject json;
//    json.insert("username", nameString);
//    json.insert("email", emailString);
//    json.insert("password", passwordString);
//    QJsonDocument jsonDoc(obj2);
//    QByteArray jsonData = jsonDoc.toJson();
//    this->post(location, jsonData);
//    this->post(location, QJsonDocument(obj2).toJson());
}
