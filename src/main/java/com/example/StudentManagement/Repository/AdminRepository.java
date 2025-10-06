package com.example.StudentManagement.Repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.Optional;

@Repository
public class AdminRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<AdminData> findAdminById(String adminId) {
        String sql = "SELECT ADMIN_ID, PASSWORD FROM ADMIN WHERE ADMIN_ID = :adminId";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("adminId", adminId);

        Object result;
        try {
            result = query.getSingleResult();
        } catch (Exception e) {
            return Optional.empty();
        }

        Object[] row = (Object[]) result;
        AdminData adminData = new AdminData((String) row[0], (String) row[1]);
        return Optional.of(adminData);
    }


    public static class AdminData {
        private final String adminId;
        private final String password;

        public AdminData(String adminId, String password) {
            this.adminId = adminId;
            this.password = password;
        }

        public String getAdminId() { return adminId; }
        public String getPassword() { return password; }
    }
}
