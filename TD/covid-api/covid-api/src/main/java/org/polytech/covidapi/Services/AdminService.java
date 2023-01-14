package org.polytech.covidapi.Services;
import java.util.ArrayList;
import java.util.List;

import org.polytech.covidapi.Repository.AdminRepository;
import org.polytech.covidapi.Table.Admin;
import org.polytech.covidapi.Table.Centre;
import org.polytech.covidapi.Table.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin getAdmin(int id){
        return adminRepository.getReferenceById(id);
    }

    public List<Admin> getAdmins(){
        List<Admin> admins = new ArrayList<>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }

    public List<Admin> getByCentre(Centre centre){
        List<Admin>admins = new ArrayList<>();
        adminRepository.findByCentre(centre).forEach(admins::add);
        return admins;
    }

    public List<RendezVous> deleteRendezVous(){
        return null;
    }
}
