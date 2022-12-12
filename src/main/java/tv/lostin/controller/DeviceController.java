package tv.lostin.controller;

import tv.lostin.entity.Device;
import tv.lostin.request.DeviceDTO;
import tv.lostin.response.DeviceVO;
import tv.lostin.response.JsonResponse;
import tv.lostin.service.DeviceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/28
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    /**
     * 添加设备
     *
     * @param dto
     * @return
     */
    @PostMapping("/")
    public JsonResponse<DeviceVO> create(@RequestBody DeviceDTO dto) {
        Device entity = deviceService.create(dto);
        DeviceVO vo = new DeviceVO();
        BeanUtils.copyProperties(entity, vo);
        return JsonResponse.success(vo);
    }

    /**
     * 更新设备
     *
     * @param dto
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public JsonResponse<DeviceVO> update(@RequestBody DeviceDTO dto, @PathVariable(value = "id") Long id) {
        Device entity = deviceService.update(id, dto);
        DeviceVO vo = new DeviceVO();
        BeanUtils.copyProperties(entity, vo);
        return JsonResponse.success(vo);
    }

    /**
     * 设备列表
     *
     * @return
     */
    @GetMapping("/")
    public JsonResponse<List<DeviceVO>> query() {
        List<Device> list = deviceService.all();
        List<DeviceVO> voList = new ArrayList<>();
        if (!list.isEmpty()) {
            list.forEach(e -> {
                DeviceVO vo = new DeviceVO();
                BeanUtils.copyProperties(e, vo);
                voList.add(vo);
            });
        }
        return JsonResponse.success(voList);
    }

    /**
     * 设备信息
     *
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public JsonResponse<DeviceVO> info(@PathVariable(value = "id") Long id) {
        Device entity = deviceService.info(id);
        DeviceVO vo = new DeviceVO();
        BeanUtils.copyProperties(entity, vo);
        return JsonResponse.success(vo);
    }

    @DeleteMapping("/{id}")
    public JsonResponse<String> delete(@PathVariable(value = "id") Long id) {
        deviceService.delete(id);
        return JsonResponse.success("success");
    }
}
