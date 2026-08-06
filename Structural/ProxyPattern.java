/*
The Proxy Pattern provides a placeholder (proxy) object that controls access to another object (the real object).
The client interacts with the Proxy, and the Proxy decides whether and when to forward the request to the real object.

*/


// Subject Interface
interface FileService {
    void readFile();
}

// Real Subject
class RealFileService implements FileService {

    @Override
    public void readFile() {
        System.out.println("Reading confidential file...");
    }
}

class FileProxy implements FileService {

    private RealFileService realFile;
    private String role;

    public FileProxy(String role) {
        this.role = role;
    }

    @Override
    public void readFile() {

        if (!role.equals("ADMIN")) {
            System.out.println("Access Denied");
            return;
        }

        if (realFile == null) {
            realFile = new RealFileService();
        }

        realFile.readFile();
    }
}

public class ProxyPattern {
    public static void main(String[] args) {

        FileService user = new FileProxy("USER");

        user.readFile();

        FileService admin = new FileProxy("ADMIN");

        admin.readFile();
    }
}


/*
Output :
Access Denied
Reading confidential file...
*/
 
