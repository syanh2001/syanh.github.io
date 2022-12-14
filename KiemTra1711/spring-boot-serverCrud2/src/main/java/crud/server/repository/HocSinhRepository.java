package crud.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import crud.server.model.HocSinh;

public interface HocSinhRepository extends JpaRepository <HocSinh, Long> {
//	List<HocSinh> findByDadonghocphi(boolean dadonghocphi);
	List<HocSinh> findByLophocContaining(String lophoc);
}
