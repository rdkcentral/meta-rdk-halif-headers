SUMMARY = "RMF Audio Capture HAL Header definitions"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

PN = "rmfaudiocapture-headers"

inherit allarch
SRC_URI = "${CMF_GITHUB_ROOT}/rdk-halif-rmf_audio_capture;protocol=${CMF_GITHUB_PROTOCOL};nobranch=1"

S = "${WORKDIR}/git"

# this is a Header package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS_${PN}-dev = ""

do_install() {
    install -d ${D}${includedir}/media-utils
    install -d ${D}${includedir}/media-utils/audioCapture
    install -m 0644 ${S}/include/*.h ${D}${includedir}/media-utils/audioCapture
}

do_install[vardepsexclude] += "S"
