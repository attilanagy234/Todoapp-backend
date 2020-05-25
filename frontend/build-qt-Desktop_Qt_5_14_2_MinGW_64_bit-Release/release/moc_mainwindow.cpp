/****************************************************************************
** Meta object code from reading C++ file 'mainwindow.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.14.2)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include <memory>
#include "../../qt/mainwindow.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#include <QtCore/QList>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'mainwindow.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.14.2. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_MainWindow_t {
    QByteArrayData data[27];
    char stringdata0[424];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_MainWindow_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_MainWindow_t qt_meta_stringdata_MainWindow = {
    {
QT_MOC_LITERAL(0, 0, 10), // "MainWindow"
QT_MOC_LITERAL(1, 11, 3), // "get"
QT_MOC_LITERAL(2, 15, 0), // ""
QT_MOC_LITERAL(3, 16, 8), // "location"
QT_MOC_LITERAL(4, 25, 4), // "post"
QT_MOC_LITERAL(5, 30, 4), // "data"
QT_MOC_LITERAL(6, 35, 27), // "on_signInPushButton_clicked"
QT_MOC_LITERAL(7, 63, 9), // "readyRead"
QT_MOC_LITERAL(8, 73, 22), // "authenticationRequired"
QT_MOC_LITERAL(9, 96, 14), // "QNetworkReply*"
QT_MOC_LITERAL(10, 111, 5), // "reply"
QT_MOC_LITERAL(11, 117, 15), // "QAuthenticator*"
QT_MOC_LITERAL(12, 133, 13), // "authenticator"
QT_MOC_LITERAL(13, 147, 9), // "encrypted"
QT_MOC_LITERAL(14, 157, 8), // "finished"
QT_MOC_LITERAL(15, 166, 24), // "networkAccessibleChanged"
QT_MOC_LITERAL(16, 191, 43), // "QNetworkAccessManager::Networ..."
QT_MOC_LITERAL(17, 235, 10), // "accessible"
QT_MOC_LITERAL(18, 246, 34), // "preSharedKeyAuthenticationReq..."
QT_MOC_LITERAL(19, 281, 30), // "QSslPreSharedKeyAuthenticator*"
QT_MOC_LITERAL(20, 312, 27), // "proxyAuthenticationRequired"
QT_MOC_LITERAL(21, 340, 13), // "QNetworkProxy"
QT_MOC_LITERAL(22, 354, 5), // "proxy"
QT_MOC_LITERAL(23, 360, 9), // "sslErrors"
QT_MOC_LITERAL(24, 370, 16), // "QList<QSslError>"
QT_MOC_LITERAL(25, 387, 6), // "errors"
QT_MOC_LITERAL(26, 394, 29) // "on_registerPushButton_clicked"

    },
    "MainWindow\0get\0\0location\0post\0data\0"
    "on_signInPushButton_clicked\0readyRead\0"
    "authenticationRequired\0QNetworkReply*\0"
    "reply\0QAuthenticator*\0authenticator\0"
    "encrypted\0finished\0networkAccessibleChanged\0"
    "QNetworkAccessManager::NetworkAccessibility\0"
    "accessible\0preSharedKeyAuthenticationRequired\0"
    "QSslPreSharedKeyAuthenticator*\0"
    "proxyAuthenticationRequired\0QNetworkProxy\0"
    "proxy\0sslErrors\0QList<QSslError>\0"
    "errors\0on_registerPushButton_clicked"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_MainWindow[] = {

 // content:
       8,       // revision
       0,       // classname
       0,    0, // classinfo
      12,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    1,   74,    2, 0x0a /* Public */,
       4,    2,   77,    2, 0x0a /* Public */,
       6,    0,   82,    2, 0x08 /* Private */,
       7,    0,   83,    2, 0x08 /* Private */,
       8,    2,   84,    2, 0x08 /* Private */,
      13,    1,   89,    2, 0x08 /* Private */,
      14,    1,   92,    2, 0x08 /* Private */,
      15,    1,   95,    2, 0x08 /* Private */,
      18,    2,   98,    2, 0x08 /* Private */,
      20,    2,  103,    2, 0x08 /* Private */,
      23,    2,  108,    2, 0x08 /* Private */,
      26,    0,  113,    2, 0x08 /* Private */,

 // slots: parameters
    QMetaType::Void, QMetaType::QString,    3,
    QMetaType::Void, QMetaType::QString, QMetaType::QByteArray,    3,    5,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 9, 0x80000000 | 11,   10,   12,
    QMetaType::Void, 0x80000000 | 9,   10,
    QMetaType::Void, 0x80000000 | 9,   10,
    QMetaType::Void, 0x80000000 | 16,   17,
    QMetaType::Void, 0x80000000 | 9, 0x80000000 | 19,   10,   12,
    QMetaType::Void, 0x80000000 | 21, 0x80000000 | 11,   22,   12,
    QMetaType::Void, 0x80000000 | 9, 0x80000000 | 24,   10,   25,
    QMetaType::Void,

       0        // eod
};

void MainWindow::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        auto *_t = static_cast<MainWindow *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->get((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 1: _t->post((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QByteArray(*)>(_a[2]))); break;
        case 2: _t->on_signInPushButton_clicked(); break;
        case 3: _t->readyRead(); break;
        case 4: _t->authenticationRequired((*reinterpret_cast< QNetworkReply*(*)>(_a[1])),(*reinterpret_cast< QAuthenticator*(*)>(_a[2]))); break;
        case 5: _t->encrypted((*reinterpret_cast< QNetworkReply*(*)>(_a[1]))); break;
        case 6: _t->finished((*reinterpret_cast< QNetworkReply*(*)>(_a[1]))); break;
        case 7: _t->networkAccessibleChanged((*reinterpret_cast< QNetworkAccessManager::NetworkAccessibility(*)>(_a[1]))); break;
        case 8: _t->preSharedKeyAuthenticationRequired((*reinterpret_cast< QNetworkReply*(*)>(_a[1])),(*reinterpret_cast< QSslPreSharedKeyAuthenticator*(*)>(_a[2]))); break;
        case 9: _t->proxyAuthenticationRequired((*reinterpret_cast< const QNetworkProxy(*)>(_a[1])),(*reinterpret_cast< QAuthenticator*(*)>(_a[2]))); break;
        case 10: _t->sslErrors((*reinterpret_cast< QNetworkReply*(*)>(_a[1])),(*reinterpret_cast< const QList<QSslError>(*)>(_a[2]))); break;
        case 11: _t->on_registerPushButton_clicked(); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 4:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QNetworkReply* >(); break;
            }
            break;
        case 5:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QNetworkReply* >(); break;
            }
            break;
        case 6:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QNetworkReply* >(); break;
            }
            break;
        case 8:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QNetworkReply* >(); break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QSslPreSharedKeyAuthenticator* >(); break;
            }
            break;
        case 9:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QNetworkProxy >(); break;
            }
            break;
        case 10:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QList<QSslError> >(); break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QNetworkReply* >(); break;
            }
            break;
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject MainWindow::staticMetaObject = { {
    QMetaObject::SuperData::link<QMainWindow::staticMetaObject>(),
    qt_meta_stringdata_MainWindow.data,
    qt_meta_data_MainWindow,
    qt_static_metacall,
    nullptr,
    nullptr
} };


const QMetaObject *MainWindow::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *MainWindow::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_MainWindow.stringdata0))
        return static_cast<void*>(this);
    return QMainWindow::qt_metacast(_clname);
}

int MainWindow::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QMainWindow::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 12)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 12;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 12)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 12;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
