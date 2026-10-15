package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .organizationName("Green Earth")
                .address("123 Eco St")
                .build());
        organizerList.add(Organizer.builder()
                .id(2L)
                .organizationName("Animal Rescue")
                .address("456 Paw Ave")
                .build());
        organizerList.add(Organizer.builder()
                .id(3L)
                .organizationName("Food Bank")
                .address("789 Harvest Rd")
                .build());
        organizerList.add(Organizer.builder()
                .id(4L)
                .organizationName("Clean Water")
                .address("101 River Ln")
                .build());
        organizerList.add(Organizer.builder()
                .id(5L)
                .organizationName("Education Fund")
                .address("202 School Blvd")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        Integer firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex, Math.min(firstIndex + pageSize, organizerList.size()));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}