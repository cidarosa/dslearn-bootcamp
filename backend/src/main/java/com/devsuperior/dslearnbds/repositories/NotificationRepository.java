package com.devsuperior.dslearnbds.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
	//buscar notificações do usuário
	//forma simplificada e incompleta, depois vai atualizar
	Page<Notification> findByUser(User user, Pageable pageable);

}
