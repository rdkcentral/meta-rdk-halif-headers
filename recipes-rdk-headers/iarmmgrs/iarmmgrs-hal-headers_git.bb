# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

# deepSleepMgr.h & plat_power.h are now taken from the rdkcentral git hub
# TODO further review should be done on this recipe to remove any unused header
# files and design changes for used headers like mfr headers

SUMMARY = "IARMmgrs HAL definition"
SECTION = "console/utils"

LICENSE = "Apache-2.0 & ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=83a31d934b0cc2ab2d44a329445b4366"


SRC_URI = "${CMF_GITHUB_ROOT}/iarmmgrs;${CMF_GITHUB_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

inherit allarch

# this is a HAL package only, nothing to build
do_compile[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
DEPENDS="deepsleep-manager-headers power-manager-headers"
RDEPENDS:${PN}-dev = ""

do_install() {
    install -d ${D}${includedir}/rdk/iarmmgrs-hal
    install -m 0644 ${S}/hal/include/comcastIrKeyCodes.h ${D}${includedir}/rdk/iarmmgrs-hal
    install -m 0644 ${S}/mfr/include/mfrMgr.h ${D}${includedir}/rdk/iarmmgrs-hal
    install -m 0644 ${S}/mfr/include/mfrTypes.h ${D}${includedir}/rdk/iarmmgrs-hal
    install -m 0644 ${S}/mfr/common/include/mfrApi.h ${D}${includedir}/rdk/iarmmgrs-hal
    install -m 0644 ${S}/mfr/include/mfr_wifi_types.h ${D}${includedir}/rdk/iarmmgrs-hal
    install -m 0644 ${S}/mfr/include/mfr_wifi_api.h ${D}${includedir}/rdk/iarmmgrs-hal
    install -m 0644 ${S}/mfr/include/mfr_temperature.h ${D}${includedir}/rdk/iarmmgrs-hal
    install -m 0644 ${S}/sysmgr/include/sysMgr.h ${D}${includedir}/rdk/iarmmgrs-hal

    install -m 0644 ${S}/deviceUpdateMgr/include/deviceUpdateMgr.h ${D}${includedir}/rdk/iarmmgrs-hal
    install -m 0644 ${S}/mfr/include/mfr_temperature.h ${D}${includedir}/rdk/iarmmgrs-hal
    if ${@bb.utils.contains('DISTRO_FEATURES' , 'enable_maintenance_manager', 'true', 'false', d)}; then
        install -m 0644 ${S}/maintenance/include/maintenanceMGR.h ${D}${includedir}/rdk/iarmmgrs-hal
    fi
}

