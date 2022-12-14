package crud.server.controller;

import crud.server.model.HocSinh;

import crud.server.repository.HocSinhRepository;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HocSinhController {

  @Autowired
  HocSinhRepository hocsinhRepository;

  @GetMapping("/hocsinhs")
  public ResponseEntity<List<HocSinh>> getAllHocsinhs(
		    @RequestParam(required = false) String lophoc
		  ) {
		    try {
		      List<HocSinh> hocsinhs = new ArrayList<HocSinh>();
		      if (lophoc == null) hocsinhRepository
		        .findAll()
		        .forEach(hocsinhs::add); 
		      else hocsinhRepository
		        .findByLophocContaining(lophoc)
		        .forEach(hocsinhs::add);
		      if (hocsinhs.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(hocsinhs, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }

		  @GetMapping("/hocsinhs/{mahs_syanh}")
		  public ResponseEntity<HocSinh> getHocsinhById(@PathVariable("mahs_syanh") long mahs_syanh) {
		    java.util.Optional<HocSinh> hocsinhData = hocsinhRepository.findById(mahs_syanh);
		    if (hocsinhData.isPresent()) {
		      return new ResponseEntity<>(hocsinhData.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		  }

		  @PostMapping("/hocsinhs")
		  public ResponseEntity<HocSinh> createHocsinh(
		    @RequestBody HocSinh hocsinh
		  ) {
		    try {
		    	HocSinh _hocsinh = hocsinhRepository.save(
		        new HocSinh(
		        		hocsinh.getLophoc(),
		        		hocsinh.getQuequan(),
		        		hocsinh.getDiemtoan(),
		        		hocsinh.getDiemvan(),
		        		hocsinh.getNgayvaotruong()
		        		)
		      );
		      return new ResponseEntity<>(_hocsinh, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }

		  @PutMapping("/hocsinhs/{mahs_syanh}")
		  public ResponseEntity<HocSinh> updateHocsinh(
		    @PathVariable("mahs_syanh") long mahs_syanh,
		    @RequestBody HocSinh hocsinh
		  ) {
		    java.util.Optional<HocSinh> hocsinhData = hocsinhRepository.findById(mahs_syanh);
		    if (hocsinhData.isPresent()) {
		    	HocSinh _hocsinh = hocsinhData.get();
		    	_hocsinh.setLophoc(hocsinh.getLophoc());
		    	_hocsinh.setQuequan(hocsinh.getQuequan());
		    	_hocsinh.setDiemtoan(hocsinh.getDiemtoan());
		    	_hocsinh.setDiemvan(hocsinh.getDiemvan());
		    	_hocsinh.setNgayvaotruong(hocsinh.getNgayvaotruong());
		      return new ResponseEntity<>(
		    		  hocsinhRepository.save(_hocsinh),
		        HttpStatus.OK
		      );
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		  }

		  @DeleteMapping("/hocsinhs/{mahs_syanh}")
		  public ResponseEntity<HttpStatus> deleteHocsinh(
		    @PathVariable("mahs_syanh") long mahs_syanh
		  ) {
		    try {
		    	hocsinhRepository.deleteById(mahs_syanh);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }

		  @DeleteMapping("/hocsinhs")
		  public ResponseEntity<HttpStatus> deleteAllHocsinhs() {
		    try {
		    	hocsinhRepository.deleteAll();
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }

//		  @GetMapping("/students/published")
//		  public ResponseEntity<List<HocSinh>> findByDadonghocphi() {
//		    try {
//		      List<HocSinh> students = hocsinhRepository.findByDadonghocphi(false);
//		      if (students.isEmpty()) {
//		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		      }
//		      return new ResponseEntity<>(students, HttpStatus.OK);
//		    } catch (Exception e) {
//		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//		  }
		}
