  "Initial Set up
set number
set mouse =a
set numberwidth=1
set clipboard=unnamed
syntax enable
set showcmd
set ruler
set encoding=utf-8
set showmatch
set sw=2
set laststatus =2
set noshowmode
set smartindent
set nowrap
set incsearch
"End Initial Set up

"Plugin Manager
call plug#begin('$HOME/.vim/plugged')

"plugins"
Plug 'franbach/miramare'
Plug 'easymotion/vim-easymotion' 
Plug 'scrooloose/nerdtree'
Plug 'artanikin/vim-synthwave84'
Plug 'arzg/vim-colors-xcode'
Plug 'bluz71/vim-nightfly-guicolors'
Plug 'neoclide/coc.nvim', {'branch': 'release'}
Plug 'rakr/vim-one'
Plug 'vim-airline/vim-airline'
Plug 'vim-airline/vim-airline-themes'
Plug 'powerline/fonts'
Plug 'ycm-core/YouCompleteMe'
Plug 'sainnhe/sonokai'
"end plugins"


call plug#end()
"End Plugin Manager

"Keys Maps
let mapleader=" " 
nmap <Leader>s <Plug>(easymotion-s2)
nmap <Leader>nt :NERDTreeFind<CR>
nmap <silent> gd <Plug>(coc-definition)
nmap <silent> gy <Plug>(coc-type-definition)
nmap <silent> gi <Plug>(coc-implementation)
nmap <silent> gr <Plug>(coc-references)
nmap <Leader>p <Plug>(Prittier)
nmap <Leader>w :w <CR>
nmap <Leader>r :source% <CR> 
nnoremap <silent> ba  :bprevious<cr>
nnoremap <silent> bb :bnext<cr>
nnoremap <silent> BA :bfirst<cr>
nnoremap <silent> BB :blast<cr>
if &filetype == "javascript" || &filetype == "python"
   inoremap <c-space> <C-x><C-u>
 else
   inoremap <silent><expr> <c-space> coc#refresh()

 endif
"End Keys Maps

"COLORSCHEME
if has('termguicolors')
  set termguicolors
endif
let g:sonokai_style = 'shusia'
let g:sonokai_enable_italic = 1
let g:sonokai_disable_italic_comment = 1
colorscheme sonokai
let g:airline_theme='violet'
let g:airline_section_b = '%{strftime("%c")}'
let g:airline_section_t = 'BN: %{bufnr("%")}'
let g:airline_powerline_fonts = 1 
let g:airline#extensions#tabline#enabled = 1
let g:airline#extensions#tabline#left_sep = ' '
let g:airline#extensions#tabline#left_alt_sep ='▸▸' 
let g:airline#extensions#tabline#formatter = 'unique_tail'
"Credit joshdick
"Use 24-bit (true-color) mode in Vim/Neovim when outside tmux.
"If you're using tmux version 2.2 or later, you can remove the outermost $TMUX check and use tmux's 24-bit color support
"(see < http://sunaku.github.io/tmux-24bit-color.html#usage > for more information.)
"if (empty($TMUX))
 " if (has("nvim"))
  "For Neovim 0.1.3 and 0.1.4 < https://github.com/neovim/neovim/pull/2198 >
  "let $NVIM_TUI_ENABLE_TRUE_COLOR=1
"  endif
  "For Neovim > 0.1.5 and Vim > patch 7.4.1799 < https://github.com/vim/vim/commit/61be73bb0f965a895bfb064ea3e55476ac175162 >
  "Based on Vim patch 7.4.1770 (`guicolors` option) < https://github.com/vim/vim/commit/8a633e3427b47286869aa4b96f2bfc1fe65b25cd >
  " < https://github.com/neovim/neovim/wiki/Following-HEAD#20160511 >
  "if (has("termguicolors"))
    "set termguicolors
"  endif
"endif


"set background=dark " for the dark version
" set background=light " for the light version
"colorscheme one
"End COLORSCHEME




let g:kite_supported_languages = ['javascript', 'python']
autocmd FileType python let b:coc_suggest_disable = 1
autocmd FileType javascript let b:coc_suggest_disable = 1
autocmd FileType scss setl iskeyword+=@-@




"nerd tree configuration
  
autocmd StdinReadPre * let s:std_in=1
"autocmd VimEnter * if argc() == 0 && !exists("s:std_in") | NERDTree | endif 
autocmd vimenter * NERDTree $Programming
let g:NERDTreeDirArrowExpandable = '▸'
let g:NERDTreeDirArrowCollapsible = '▾'
