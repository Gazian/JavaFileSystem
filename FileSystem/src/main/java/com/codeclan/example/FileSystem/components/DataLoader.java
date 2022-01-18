package com.codeclan.example.FileSystem.components;

import com.codeclan.example.FileSystem.models.File;
import com.codeclan.example.FileSystem.models.Folder;
import com.codeclan.example.FileSystem.models.User;
import com.codeclan.example.FileSystem.repository.FileRepository;
import com.codeclan.example.FileSystem.repository.FolderRepository;
import com.codeclan.example.FileSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        User barry = new User("Barry");
        userRepository.save(barry);

        User nicola = new User("Nicola");
        userRepository.save(nicola);

        User mark = new User("Mark");
        userRepository.save(mark);

        Folder telephony = new Folder("Telephony Folder", barry);
        folderRepository.save(telephony);

        Folder bau = new Folder("BAU Folder", barry);
        folderRepository.save(bau);

        Folder management = new Folder("Management Folder", nicola);
        folderRepository.save(management);

        Folder meeting = new Folder("Meeting Folder", nicola);
        folderRepository.save(meeting);

        Folder rfb = new Folder("RFB Folder", mark);
        folderRepository.save(rfb);

        Folder nexus = new Folder("Nexus Folder", nicola);
        folderRepository.save(nexus);

        File telephonyPdf = new File("Telephony PDF", ".pdf", 17.2, telephony);
        fileRepository.save(telephonyPdf);

        File telephonyXls = new File("Telephony XLS", ".xls", 25.2, telephony);
        fileRepository.save(telephonyXls);

        File telephonyDoc = new File("Telephony Doc", ".doc", 35.2, telephony);
        fileRepository.save(telephonyDoc);

        File bauPdf = new File("BAU PDF", ".pdf", 17.2, bau);
        fileRepository.save(bauPdf);

        File bauXls = new File("BAU XLS", ".xls", 25.2, bau);
        fileRepository.save(bauXls);

        File bauDoc = new File("BAU Doc", ".doc", 35.2, bau);
        fileRepository.save(bauDoc);

        File managementPdf = new File("Management PDF", ".pdf", 17.2, management);
        fileRepository.save(managementPdf);

        File managementDoc = new File("Management Doc", ".doc", 35.2, management);
        fileRepository.save(managementDoc);

        File meetingXls = new File("Meeting XLS", ".xls", 17.2, meeting);
        fileRepository.save(meetingXls);

        File rfbPdf = new File("RFB PDF", ".pdf", 17.2, rfb);
        fileRepository.save(rfbPdf);

        File rfbXls = new File("RFB XLS", ".xls", 25.2, rfb);
        fileRepository.save(rfbXls);

        File rfbDoc = new File("RFB Doc", ".doc", 35.2, rfb);
        fileRepository.save(rfbDoc);

        File nexusPdf = new File("Nexus PDF", ".pdf", 17.2, nexus);
        fileRepository.save(nexusPdf);

        File nexusXls = new File("Nexus XLS", ".xls", 25.2, nexus);
        fileRepository.save(nexusXls);

        File nexusDoc = new File("Nexus Doc", ".doc", 35.2, nexus);
        fileRepository.save(nexusDoc);

    }
}
