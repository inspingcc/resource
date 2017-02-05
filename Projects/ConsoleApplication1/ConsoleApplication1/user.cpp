#include <iostream>
#include <cstring>
#include <sstream>

using namespace std;

//基础用户类
class BaseUser

{
public:
    BaseUser();
    BaseUser(long uid, string name, string passwd);
    ~BaseUser();
    virtual void toString()
    {
        cout << "uid:" << this->uid << "\tname:" << this->name.data() << "\tpasswd:" << this->passwd.data() << endl;
    }

protected:
    long uid;
    string name;
    string passwd;
};

BaseUser::BaseUser()
{

}

BaseUser::BaseUser
(long uid, string name, string passwd)
{
    this->uid = uid;
    this->name = name;
    this->passwd = passwd;
}

BaseUser::~BaseUser()
{

}

//正常用户的类
class NormalUser: BaseUser
{
public:
    NormalUser();
    NormalUser(long uid, string name, string passwd, long nNumber);
    NormalUser(const NormalUser &obj)
    {
        uid = obj.uid;
        name = obj.name;
        passwd = obj.passwd;
        nNumber = obj.nNumber;
    }
    ~NormalUser();
    virtual void toString()
    {
        cout << "uid:" << this->uid << "\tname:" << this->name.data() << "\tpasswd:" << this->passwd.data() << "\tnNumber:" << this->nNumber << endl;
    }
    NormalUser operator+(const NormalUser &obj)
    {
        NormalUser temp = obj;
        temp.nNumber = this->nNumber + obj.nNumber;
        return temp;
    }

private:
    long nNumber;
};

NormalUser::NormalUser()
{
}

NormalUser::NormalUser(long uid, string name, string passwd, long nNumber)
{
    this->uid		= uid;
    this->name		= name;
    this->passwd	= passwd;
    this->nNumber	= nNumber;
}

NormalUser::~NormalUser()
{

}

//管理员用户
class ManagerUser: BaseUser

{
public:
    ManagerUser
    ();
    ManagerUser
    (long uid, string name, string passwd, int *power, int pLength);
    ~ManagerUser
    ();
    virtual void toString()
    {
        string powerStr = "[";

        for(int i = 0; i < this->pLength; i++)
        {
            stringstream ss ;
            ss << *power;

            if(i != 0)
            {
                powerStr.append(",");
            }

            powerStr.append(ss.str());
            power++;
        }

        powerStr.append("]");
        cout << "uid:" << this->uid << "\tname:" << this->name.data() << "\tpasswd:" << this->passwd.data() << "\tpower:" << powerStr.data() << endl;
    }

private:
    int *power;
    int pLength;
};

ManagerUser::ManagerUser()
{
}

ManagerUser::
ManagerUser(long uid, string name, string passwd, int *power, int pLength): pLength(pLength)
{
    this->uid = uid;
    this->name = name;
    this->passwd = passwd;
    this->power = power;
}

ManagerUser::~ManagerUser() {}


//void  main()
//{
//    //BaseUser b = BaseUser(1,"111111","1111");
//    //b.toString();
//
//    //NormalUser n = NormalUser(2,"222222","2222",22);
//    //n.toString();
//
//    //int power[] ={1,2,3,4,5,6,7,8,9};
//    //ManagerUser m = ManagerUser(2,"222222","2222",power,sizeof(power)/sizeof(power[0]));
//    //m.toString();
//
//    NormalUser n = NormalUser(2, "222222", "2222", 22);
//    NormalUser n1 = NormalUser(2, "222222", "2222", 22);
//    NormalUser n2 = n + n1;
//    n2.toString();
//
//    system("pause");
//}