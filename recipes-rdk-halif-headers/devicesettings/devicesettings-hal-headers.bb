# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

SUMMARY = "Devicesettings HAL definition"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

#SRC_URI = "${CMF_GITHUB_ROOT}/rdk-halif-device_settings;${CMF_GITHUB_SRC_URI_SUFFIX}"
SRC_URI = "git://github.com/rdkcentral/rdk-halif-device_settings.git;protocol=git;branch=feature/dsVideoPort_Add_new_AVI_APIs;"
SRCREV="8edbdf9d2a98d7ec428c662d064602c0255c3efa"

inherit allarch

S = "${WORKDIR}/git"

# this is a HAL package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS:${PN}-dev = ""
# to include the headers in the SDK
ALLOW_EMPTY:${PN} = "1"

do_install() {
    install -d ${D}${includedir}/rdk/halif/ds-hal
    install -m 0644 ${S}/include/*.h ${D}${includedir}/rdk/halif/ds-hal
}

do_install[vardepsexclude] += "S"

